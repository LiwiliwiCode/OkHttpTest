package com.okhttptest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.okhttptest.R;
import com.okhttptest.Util.LoginUtil;

/**
 * 首页
 * Created by hhmsw on 2017/9/19.
 */

public class HomeActivity extends Activity {
    public String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        ImageView i;

        /**
         * 3秒之后进入主界面
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //是否登录
                if (isLogin()) {
                    //登录
                    startIntent(MainActivity.class);
                } else {
                    //未登录
                    startIntent(NavigationActivity.class);
                }
            }
        }, 3000);
    }

    /**
     * 用户是否登录
     * @return
     */
    private boolean isLogin() {
        return LoginUtil.isLogin();
    }

    /**
     * 根据目标Activity 进行跳转
     * @param cla
     */
    private void startIntent(Class<?> cla) {
        Intent intent = new Intent(HomeActivity.this, cla);
        startActivity(intent);
        finish();
    }

}
