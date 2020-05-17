package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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

public class LogActivity extends BaseActivity<LogRegPresenter> implements LogOrReg.GView {
    private EditText logName;
    private EditText logPass;
    private Button logFlagStatus;
    private static final String TAG = "LogActivity";
private   String s;
    @Override
    public void initView() {

        logName = (EditText) findViewById(R.id.log_name);
        logPass = (EditText) findViewById(R.id.log_pass);
        logFlagStatus = (Button) findViewById(R.id.log_flag_status);
     s = logName.getText().toString();
    }

    @Override
    public void initData() {
        mPresenter = new LogRegPresenter(new LogRegModel(),this);
        logFlagStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.LogSuccess();
            }
        });
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_log;
    }

    @Override
    public void showToast() {

    }

    @Override
    public void showMsg(String code) {
        Log.i(TAG, "showMsg: "+code);
        if (code.equals(200)){

        
        }else {

        }
    }

    @Override
    public String Uname() {
        return logName.getText().toString();
    }

    @Override
    public String UPass() {
        return logPass.getText().toString();
    }

}
