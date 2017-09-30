package com.okhttptest.Util;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Okhttp 网络请求工具类
 * Created by hhmsw on 2017/9/21.
 */

public class NetUtil {

    private static final String TAG = "NetUtil";
    private OkHttpClient client;
    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private static ExecutorService service;

    private NetUtil() {
        client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).build();
        //client = new OkHttpClient.Builder().addInterceptor(new RetryIntercepter(3)).build();
        service = Executors.newFixedThreadPool(3);
    }


    private static class NetUtilFragctory {
        private static NetUtil instance = new NetUtil();
    }

    public static NetUtil getInstance() {

        return NetUtilFragctory.instance;
    }

    public interface NetCallback {
        void Fail();

        void Success(String json);
    }

    public void Get(final String url, final NetCallback callback) throws IOException {

            service.execute(new Runnable() {
                @Override
                public void run() {
                    Request request = new Request.Builder()
                            .url(url)
                            .build();
                    Log.e(TAG, "Get: " + url);
                    Call call = client.newCall(request);
                    call.enqueue(new Callback() {

                        @Override
                        public void onFailure(Call call, IOException e) {
                            callback.Fail();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            callback.Success(response.body().string());
                        }
                    });

                }
            });


    }

    public void post(final String url, final RequestBody body, final NetCallback callback) throws IOException {

            service.execute(new Runnable() {
                @Override
                public void run() {
                    Request request = new Request.Builder()
                            .post(body)
                            .url(url)
                            .build();
                    Log.e(TAG, "post: " + url);
                    Call call = client.newCall(request);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            callback.Fail();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            callback.Success(response.body().string());
                        }
                    });
                }
            });
    }

}
