package com.okhttptest.Util;

import android.util.Log;

/**
 * Created by hhmsw on 2017/9/22.
 */

public class LogUtils {
    public static boolean SHOWLOG = true;

    public static void LogE(String TAG,String Message){
        if(SHOWLOG){
            Log.e(TAG,Message);
        }
    }
    public static void LogI(String TAG,String Message){
        if(SHOWLOG){
            Log.i(TAG,Message);
        }
    }
    public static void LogW(String TAG,String Message){
        if(SHOWLOG){
            Log.w(TAG,Message);
        }
    }
    public static void LogD(String TAG,String Message){
        if(SHOWLOG){
            Log.d(TAG,Message);
        }
    }
}
