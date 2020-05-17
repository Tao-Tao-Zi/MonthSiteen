package com.example.myapplication.mvp.view;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library.mvp.view.BaseFragment;
import com.example.myapplication.Main2Activity;
import com.example.myapplication.R;
import com.example.myapplication.adapter.TwoAdapter;
import com.example.myapplication.bean.TwoBean;
import com.example.myapplication.mvp.contract.Look;
import com.example.myapplication.mvp.model.LookModel;
import com.example.myapplication.mvp.presenter.LookPresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends BaseFragment<LookPresenter> implements Look.LView{
    private RecyclerView threeRecy;
private TwoAdapter adapter;
    private static final String TAG = "ThreeFragment";


    @Override
    public void initView() {
        threeRecy = (RecyclerView) findViewById(R.id.three_recy);
        threeRecy.setLayoutManager(new GridLayoutManager(getContext(),2));
    }

    @Override
    public void initData() {
        mPresenter = new LookPresenter(new LookModel(),this);
        mPresenter.City();
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_three;
    }

    @Override
    public void initLook(List<TwoBean.ResultBean> list) {
        Log.i(TAG, "initLook: 3"+list.size());
        if (adapter == null){
            adapter = new TwoAdapter(R.layout.layout_two_item,list);
            threeRecy.setAdapter(adapter);
            onClickAdapter(list);
        }else{
            threeRecy.setAdapter(adapter);
            onClickAdapter(list);
        }
    }
    public void onClickAdapter(List<TwoBean.ResultBean> list){
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), Main2Activity.class);
                intent.putExtra("no",list.get(position).getVedioUrl());
                startActivity(intent);
            }
        });
    }
    @Override
    public void showToast() {

    }
}
