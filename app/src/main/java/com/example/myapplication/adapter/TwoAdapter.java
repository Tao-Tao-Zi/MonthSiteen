package com.example.myapplication.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.bean.TwoBean;

import java.util.List;

public class TwoAdapter extends BaseQuickAdapter<TwoBean.ResultBean, BaseViewHolder> {
    public TwoAdapter(int layoutResId, @Nullable List<TwoBean.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TwoBean.ResultBean item) {
        ImageView view = helper.getView(R.id.two_imv);
        ImageView samil = helper.getView(R.id.imv_smail);
        Glide.with(mContext).load(item.getCoverImg()).placeholder(R.drawable.ic_launcher_background).into(view);
        Glide.with(mContext).load(item.getCoverImg()).circleCrop().placeholder(R.drawable.ic_launcher_background).into(samil);
        helper.setText(R.id.two_tv,item.getUserId()+"");
    }

}
