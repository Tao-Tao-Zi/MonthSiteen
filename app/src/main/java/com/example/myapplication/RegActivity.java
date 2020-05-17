package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.library.mvp.view.BaseActivity;
import com.example.myapplication.mvp.contract.LogOrReg;
import com.example.myapplication.mvp.model.LogRegModel;
import com.example.myapplication.mvp.presenter.LogRegPresenter;

import org.greenrobot.eventbus.EventBus;


public class RegActivity extends BaseActivity<LogRegPresenter> implements LogOrReg.GView {
    private EditText regName;
    private EditText regPass;
    private Button regFlagStatus;
    private static final String TAG = "regActivity";

    @Override
    public void initView() {
        regName = (EditText) findViewById(R.id.reg_name);
        regPass = (EditText) findViewById(R.id.reg_pass);
        regFlagStatus = (Button) findViewById(R.id.reg_flag_status);

    }

    @Override
    public void initData() {
        mPresenter = new LogRegPresenter(new LogRegModel(),this);
        regFlagStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.RegSuccess();
            }
        });
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_reg;
    }

    @Override
    public void showToast() {

    }

    @Override
    public void showMsg(String code) {

        if (code.equals(200)){

        }
    }

    @Override
    public String Uname() {
        return regName.getText().toString();
    }

    @Override
    public String UPass() {
        return regPass.getText().toString();
    }

}
