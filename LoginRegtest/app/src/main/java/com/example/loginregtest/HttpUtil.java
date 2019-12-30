package com.example.loginregtest;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtil {
    //登录
    static void loginWithOkHttp(String address,String username,String password,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
        RequestBody body = new FormBody.Builder()
                .add("loginUsername",username)
                .add("loginPassword",password)
                .build();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
    //注册
    static void registerWithOkHttp(String address,String username,String password,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(5,TimeUnit.SECONDS).build();
        RequestBody body = new FormBody.Builder()
                .add("registerUsername",username)
                .add("registerPassword",password)
                .build();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
