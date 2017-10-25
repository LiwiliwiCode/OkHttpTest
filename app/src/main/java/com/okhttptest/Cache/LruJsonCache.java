package com.okhttptest.Cache;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;

import com.okhttptest.OkHtttpApp;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hhmsw on 2017/9/22.
 * http://blog.csdn.net/xufeifandj/article/details/42195251
 * 缓存json数据，当手机无网络时，使用缓存数据
 * 1.设置缓存时间
 * 2.一级缓存Disk
 *
 */
public class LruJsonCache {

    //需要缓存的目录
    private static String DISKLRUFILENAME ="Dsk";
    //缓存大小
    private static int CHCHEMAX = 20 * 1024 * 1024;
    private DiskLruCache mDiskruCache = null;

    private LruJsonCache() {
        try {
            File file =getDiskCacheDir();
            if(!file.exists()){
                file.mkdirs();
            }
            mDiskruCache = DiskLruCache.open(file,getAppVersion(),1,CHCHEMAX);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static class LruJsonCacheFractory{
        private static LruJsonCache LruJsonCache = new LruJsonCache();
    }

    public static LruJsonCache getLruJsonCache(){
        return LruJsonCacheFractory.LruJsonCache;
    }

    /**
     * 根据缓存key获取json数据
     * @return
     * @throws IOException if reading or writing the cache directory fails
     */
    public String GetJson(String url) {
        try {
            String key = hashKeyForDisk(url);
            if(!TextUtils.isEmpty(key)){
                DiskLruCache.Snapshot snapshot = getLruJsonCache().mDiskruCache.get(key);
                if(snapshot != null){
                    InputStream is = snapshot.getInputStream(0);
                    return toStr(is);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据InputStream 获取缓存内容
     * @param is
     * @return
     */
    private static String toStr(InputStream is){
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 缓存json数据
     * @param url
     */
    public void addJson(String url,String jsoncontent) {
        String key = hashKeyForDisk(url);

            BufferedOutputStream out = null;
            try{
                DiskLruCache.Editor editor = getLruJsonCache().mDiskruCache.edit(key);
                if (editor != null) {
                    OutputStream outputStream = editor.newOutputStream(0);
                    out = new BufferedOutputStream(outputStream, 8 * 1024);
                    out.write(jsoncontent.getBytes());
                    editor.commit();
                    getLruJsonCache().mDiskruCache.flush();
                }

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(out != null){
                    try {
                        out.flush();
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
    }

    /**
     * 移除Json数据
     * @param url
     */
    public void RemoveJson(String url){
        String key = hashKeyForDisk(url);
        try {
            if(!TextUtils.isEmpty(key)){
                getLruJsonCache().mDiskruCache.remove(key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查看数据是否缓存
     * @param url
     * @return
     */
    private String hashKeyForDisk(String url) {
        String cacheKey;
        try {
            final MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(url.getBytes());
            cacheKey = bytesToHexString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            cacheKey = String.valueOf(url.hashCode());
        }
        return cacheKey;
    }

    private String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    /**
     * 创建缓存文件目录
     * @return
     */
    private File getDiskCacheDir() {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = OkHtttpApp.getContext().getExternalCacheDir().getPath();
        } else {
            cachePath = OkHtttpApp.getContext().getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + DISKLRUFILENAME);
    }

    /**
     * 获取版本号
     * @return
     */
    private int getAppVersion() {
        try {
            PackageInfo info = OkHtttpApp.getContext().getPackageManager().getPackageInfo(OkHtttpApp.getContext().getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
