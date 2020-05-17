package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

public class Main2Activity extends AppCompatActivity {
    private StandardGSYVideoPlayer main2Play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String no = intent.getStringExtra("no");
        main2Play = (StandardGSYVideoPlayer) findViewById(R.id.main2_play);
        main2Play.setUp(no,false,"");
        main2Play.startPlayLogic();

//设置返回键
        main2Play.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
