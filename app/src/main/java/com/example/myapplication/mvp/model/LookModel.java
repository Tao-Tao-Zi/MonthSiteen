package com.example.myapplication.mvp.model;

import com.example.library.http.HttpUtils;
import com.example.library.mvp.model.BaseModel;
import com.example.myapplication.api.Api;
import com.example.myapplication.bean.TwoBean;
import com.example.myapplication.mvp.contract.Look;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LookModel extends BaseModel implements Look.LModel {
    @Override
    public void requestLook(Observer<TwoBean> listObserver) {
        HttpUtils.getInstance()
                .getRetrofit()
                .create(Api.class)
                .look()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(listObserver);
    }

    @Override
    public void requestGuanzhu(Observer<TwoBean> listObserver) {
        HttpUtils.getInstance()
                .getRetrofit()
                .create(Api.class)
                .Guanzhu()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(listObserver);
    }

    @Override
    public void requestCity(Observer<TwoBean> listObserver) {
        HttpUtils.getInstance()
                .getRetrofit()
                .create(Api.class)
                .City()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(listObserver);
    }
}
