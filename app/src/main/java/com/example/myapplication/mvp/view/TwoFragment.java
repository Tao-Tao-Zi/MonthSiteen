package com.example.myapplication.mvp.view;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

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
public class TwoFragment extends BaseFragment<LookPresenter> implements Look.LView {
    private RecyclerView twoRecy;
    private TwoAdapter adapter;
    private static final String TAG = "TwoFragment";
    @Override
    public void initView() {
        twoRecy = (RecyclerView) findViewById(R.id.two_recy);

    }

    @Override
    public void initData() {
        mPresenter = new LookPresenter(new LookModel(),this);
        mPresenter.showSuccess();
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_two;
    }

    @Override
    public void showToast() {

    }

    @Override
    public void initLook(List<TwoBean.ResultBean> list) {
        Log.i(TAG, "initLook2: "+list.size());
        if (adapter == null){
            twoRecy.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            adapter = new TwoAdapter(R.layout.layout_two_item,list);
            twoRecy.setAdapter(adapter);
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
}
