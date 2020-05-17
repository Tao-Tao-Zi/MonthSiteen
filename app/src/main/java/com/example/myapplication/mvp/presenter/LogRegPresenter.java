package com.example.myapplication.mvp.presenter;

import com.example.library.mvp.presenter.BasePresenter;
import com.example.myapplication.bean.OneBean;
import com.example.myapplication.bean.RegBean;
import com.example.myapplication.mvp.contract.LogOrReg;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LogRegPresenter extends BasePresenter<LogOrReg.GModel, LogOrReg.GView> {
    public LogRegPresenter(LogOrReg.GModel mModel, LogOrReg.GView mView) {
        super(mModel, mView);
    }
    public void LogSuccess(){
        mModel.requestUser(mView.Uname(), mView.UPass(), new Observer<OneBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(OneBean oneBean) {
                String code = oneBean.getCode();
                mView.showMsg(code);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
    public void RegSuccess(){
        mModel.requestUserReg(mView.Uname(), mView.UPass(), new Observer<RegBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RegBean oneBean) {
                String code = oneBean.getCode();
                mView.showMsg(code);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
