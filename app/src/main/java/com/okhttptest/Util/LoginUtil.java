package com.okhttptest.Util;

import android.content.Context;
import android.content.SharedPreferences;

import com.okhttptest.OkHtttpApp;

/**
 * Created by hhmsw on 2017/9/19.
 * SharedPreferences 缓存类
 */

public class LoginUtil {

    private static String CACHEP = "p";
    //登录标签
    private static String LOGINSTR = "login";
    //登录状态
    private static int LOGIN = 1;
    //未登录状态
    private static int UNLOGIN = 0;

    private LoginUtil(){}

    private static class UtilPareneceFactory{
        private static SharedPreferences preference = OkHtttpApp.getContext().getSharedPreferences(CACHEP, Context.MODE_PRIVATE);
    }


    /**
     * 根据key value 添加数据
     *
     * @param k
     * @param c
     */
    public static void addValue(String k, Object c) {
        SharedPreferences.Editor editor = getpreference().edit();
        if(c instanceof  Integer){
            editor.putInt(k, (int)c);
        }else if(c instanceof  Long){
            editor.putLong(k, (long)c);
        }else if (c instanceof  Float){
            editor.putFloat(k, (float)c);
        }else if(c instanceof  Boolean){
            editor.putBoolean(k, (boolean)c);
        }else if(c instanceof  String){
            editor.putString(k, (String)c);
        }
        editor.commit();
    }

    /**
     * 将数据全部删除
     */
    public static void Remove() {
        getpreference().edit().clear();
    }

    private static SharedPreferences getpreference() {
        return UtilPareneceFactory.preference;
    }

    /**
     * 返回登录状态
     * @return
     */
    public static boolean isLogin() {
        return getpreference().getInt(LOGINSTR,UNLOGIN) == LOGIN;
    }

    /**
     * 设置登录状态
     */
    public static void setlogin(){
        addValue(LOGINSTR,LOGIN);
    }
}
