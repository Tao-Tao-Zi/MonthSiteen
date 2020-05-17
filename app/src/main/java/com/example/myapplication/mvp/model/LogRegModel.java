package com.example.myapplication.mvp.model;

import com.example.library.http.HttpUtils;
import com.example.library.mvp.model.BaseModel;
import com.example.myapplication.api.Api;
import com.example.myapplication.bean.OneBean;
import com.example.myapplication.bean.RegBean;
import com.example.myapplication.mvp.contract.LogOrReg;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LogRegModel extends BaseModel implements LogOrReg.GModel {
    @Override
    public void requestUser(String name, String pass, Observer<OneBean> li) {
        HttpUtils.getInstance()
                .getRetrofit()
                .create(Api.class)
                .Login(name,pass)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(li);
    }

    @Override
    public void requestUserReg(String name, String pass, Observer<RegBean> li) {
        HttpUtils.getInstance()
                .getRetrofit()
                .create(Api.class)
                .Reg(name,pass)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(li);
    }
}
