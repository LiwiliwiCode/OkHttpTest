package com.okhttptest.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.okhttptest.OkHtttpApp;

/**
 * Created by hhmsw on 2017/9/22.
 * 网络检查
 */

public class ConnectedUtil {


    private static ConnectivityManager mConnectivityManager = null;

    private static ConnectivityManager getConnectivityManager() {
        if (mConnectivityManager == null) {
            mConnectivityManager = (ConnectivityManager) OkHtttpApp.getContext()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
        }
        return mConnectivityManager;
    }

    /**
     * 判断WIFI网络是否可用
     *
     * @return
     */
    public static boolean isWifiConnected() {
        NetworkInfo mWiFiNetworkInfo = getConnectivityManager()
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (mWiFiNetworkInfo != null) {
            return mWiFiNetworkInfo.isAvailable();
        }

        return false;
    }


    /**
     * 判断MOBILE网络是否可用
     *
     * @return
     */
    public static boolean isMobileConnected() {
        NetworkInfo mMobileNetworkInfo = getConnectivityManager()
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mMobileNetworkInfo != null) {
            return mMobileNetworkInfo.isAvailable();
        }

        return false;
    }

    /**
     * 判断是否有网络连接
     *
     * @return
     */
    public static boolean isNetworkConnected() {
        NetworkInfo mNetworkInfo = getConnectivityManager().getActiveNetworkInfo();
        if (mNetworkInfo != null) {
            return mNetworkInfo.isAvailable();
        }

        return false;
    }
}
