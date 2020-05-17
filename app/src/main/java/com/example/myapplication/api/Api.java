package com.example.myapplication.api;

import com.example.myapplication.bean.OneBean;
import com.example.myapplication.bean.RegBean;
import com.example.myapplication.bean.TwoBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @GET("findVideo")
    Observable<TwoBean> look();
    @GET("findFocusVideo")
    Observable<TwoBean> Guanzhu();
    @GET("findCityVideo")
    Observable<TwoBean> City();

    @FormUrlEncoded
    @POST("login")
    Observable<OneBean> Login(@Field("name")String name,@Field("password")String pass);

    @FormUrlEncoded
    @POST("login")
    Observable<RegBean> Reg(@Field("name")String name, @Field("password")String pass);
}
