package com.example.library.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {

    private static HttpUtils instance;
    private HttpUtils(){}

    public static HttpUtils getInstance() {
       if (instance == null){
           instance = new HttpUtils();
       }
        return instance;
    }
    private Retrofit retrofit;

    public Retrofit getRetrofit() {
        if (retrofit == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .readTimeout(6, TimeUnit.SECONDS)
                    .writeTimeout(6, TimeUnit.SECONDS)
                    .connectTimeout(6, TimeUnit.SECONDS)
                    .build();
            Retrofit retrofit1 = new Retrofit.Builder()
                    .baseUrl("http://49.233.93.155:8080/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            retrofit = retrofit1;
        }
        return retrofit;
    }
}
