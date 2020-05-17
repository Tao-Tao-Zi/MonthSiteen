package com.example.library.mvp.presenter;

import com.example.library.mvp.model.IModel;
import com.example.library.mvp.view.IView;

public class BasePresenter<M extends IModel,V extends IView> implements IPresenter {
    protected M mModel;
    protected V mView;

    public BasePresenter(M mModel, V mView) {
        this.mModel = mModel;
        this.mView = mView;
    }

    @Override
    public void destory() {
        if (mModel!=null){
            mModel.destory();
            mModel = null;
        }
        if (mView!=null){
            mView = null;
        }
    }
}
