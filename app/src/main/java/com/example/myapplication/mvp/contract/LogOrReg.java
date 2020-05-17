package com.example.myapplication.mvp.contract;

import com.example.library.mvp.model.IModel;
import com.example.library.mvp.view.IView;
import com.example.myapplication.bean.OneBean;
import com.example.myapplication.bean.RegBean;

import java.util.List;

import io.reactivex.Observer;

public interface LogOrReg {
    interface GModel extends IModel{
        void requestUser(String name, String pass, Observer<OneBean> li);
        void requestUserReg(String name, String pass, Observer<RegBean> li);
    }
    interface GView extends IView{
        void showMsg(String code);
        String Uname();
        String UPass();
    }
}
