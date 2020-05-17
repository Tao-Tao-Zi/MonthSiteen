package com.example.myapplication.mvp.contract;

import com.example.library.mvp.model.IModel;
import com.example.library.mvp.view.IView;
import com.example.myapplication.bean.TwoBean;

import java.util.List;

import io.reactivex.Observer;

public interface Look {
    interface LModel extends IModel{
        void requestLook(Observer<TwoBean> listObserver);
        void requestGuanzhu(Observer<TwoBean> listObserver);
        void requestCity(Observer<TwoBean> listObserver);
    }
    interface LView extends IView{
        void initLook(List<TwoBean.ResultBean> list);
    }
}
