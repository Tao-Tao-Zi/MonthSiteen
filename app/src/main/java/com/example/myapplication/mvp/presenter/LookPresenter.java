package com.example.myapplication.mvp.presenter;

import android.util.Log;

import com.example.library.mvp.presenter.BasePresenter;
import com.example.myapplication.bean.TwoBean;
import com.example.myapplication.mvp.contract.Look;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LookPresenter extends BasePresenter<Look.LModel, Look.LView> {
    private List<TwoBean.ResultBean> listt = new ArrayList<>();
    private static final String TAG = "LookPresenter";
    public LookPresenter(Look.LModel mModel, Look.LView mView) {
        super(mModel, mView);
    }

    public void showSuccess(){
        mModel.requestLook(new Observer<TwoBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TwoBean list) {
                Log.i(TAG, "onNext:发现 "+list);
                List<TwoBean.ResultBean> result = list.getResult();
                mView.initLook(result);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onNext: "+e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
    public void GuanSuccess(){
        mModel.requestGuanzhu(new Observer<TwoBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TwoBean list) {
                Log.i(TAG, "onNext:关注 "+list);
                List<TwoBean.ResultBean> result = list.getResult();
                mView.initLook(result);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onNext: "+e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
    public void City(){
        mModel.requestCity(new Observer<TwoBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TwoBean list) {
                Log.i(TAG, "onNext:同城"+list);
                List<TwoBean.ResultBean> result = list.getResult();
                mView.initLook(result);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onNext: "+e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
