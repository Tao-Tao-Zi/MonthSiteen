package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.library.mvp.view.BaseActivity;
import com.example.myapplication.adapter.FragmentAdapter;
import com.example.myapplication.mvp.view.OneFragment;
import com.example.myapplication.mvp.view.ThreeFragment;
import com.example.myapplication.mvp.view.TwoFragment;
import com.google.android.material.tabs.TabLayout;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private ImageView showSlide;
    private TabLayout mainTab;
    private ImageView showLook;
    private ViewPager mainVp;
    private ImageView slideMenuImv;
    private TextView slideMenuUsename;



    private  SlidingMenu slidingMenu;
    private List<String> listTab = new ArrayList<>();
    private List<Fragment> listFram = new ArrayList<>();
    private FragmentAdapter adapter;
    private   OneFragment oneFragment;
    private TwoFragment twoFragment;
   private ThreeFragment threeFragment;
    @Override
    public void initView() {
        showSlide = (ImageView) findViewById(R.id.show_slide);
        mainTab = (TabLayout) findViewById(R.id.main_tab);
        showLook = (ImageView) findViewById(R.id.show_look);
        mainVp = (ViewPager) findViewById(R.id.main_vp);
         oneFragment = new OneFragment();
         twoFragment = new TwoFragment();
         threeFragment = new ThreeFragment();

        showSlide();
        initTab();
        initVp();
        TogetTherAction();
    }

    private void TogetTherAction() {
        mainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mainVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mainTab.setScrollPosition(position,positionOffset,true);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initVp() {
        listFram.add(oneFragment);
        listFram.add(twoFragment);
        listFram.add(threeFragment);
        adapter = new FragmentAdapter(getSupportFragmentManager(),listFram);
        mainVp.setAdapter(adapter);
    }

    private void initTab() {
        listTab.add("关注");
        listTab.add("发现");
        listTab.add("同城");
        for (int i = 0; i < listTab.size(); i++) {
            mainTab.addTab(mainTab.newTab().setText(listTab.get(i)));
        }
    }

    @Override
    public void initData() {
        showSlide.setOnClickListener(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showToast() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.show_slide:
                    slidingMenu.showMenu();
                break;
        }
    }

    private void showSlide(){
//        Intent intent = getIntent();
//        String na = intent.getStringExtra("na");

        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setMenu(R.layout.layout_slide_menu);
        slidingMenu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setBehindOffset(400);

        View menu = slidingMenu.getMenu();

        slideMenuImv = (ImageView)menu.findViewById(R.id.slide_menu_imv);
        slideMenuUsename = (TextView)menu.findViewById(R.id.slide_menu_usename);
//        if (na!=null){
//            slideMenuUsename.setText(na+"");
//        }
        slideMenuImv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LogActivity.class));
            }
        });
    }
}
