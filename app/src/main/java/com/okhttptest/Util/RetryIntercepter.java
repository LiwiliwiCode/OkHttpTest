package com.okhttptest.Util;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hhmsw on 2017/9/26.
 */

public class RetryIntercepter implements Interceptor {
    public int maxRetry;//最大重试次数
    private int retryNum = 0;//假如设置为3次重试的话，则最大可能请求4次（默认1次+3次重试）

    public RetryIntercepter(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) {

        Request request = chain.request();
        System.out.println("retryNum=" + retryNum);
        Response response = null;
        try {
            response = chain.proceed(request);
            if(response != null){
                while (!response.isSuccessful() && retryNum < maxRetry) {
                    retryNum++;
                    System.out.println("retryNum=" + retryNum);
                    response = chain.proceed(request);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

}
