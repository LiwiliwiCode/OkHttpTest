package com.okhttptest;

import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.mob.MobApplication;
import com.mob.MobSDK;
import com.okhttptest.Util.ImagePipelineConfigFactory;

/**
 * Created by hhmsw on 2017/9/19.
 */

public class OkHtttpApp extends MobApplication {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        //初始化
        Fresco.initialize(this, ImagePipelineConfigFactory.getImagePipelineConfig(context));
        MobSDK.init(context, "2155d6f9793b0", "d79f2d9912a3ac57184a4a17f0926876");
    }

    public static Context getContext(){
        return context;
    }
}
