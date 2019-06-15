package com.lzy.lazyfragmentdemo.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;

import com.lzy.lazyfragmentdemo.R;

public class SecondFragment  extends BaseFragmentTwo{
    /**
     * 由子类实现
     *
     * @return 返回子类的布局id
     */
    @Override
    int getLayoutId() {
        return R.layout.fragment_two;
    }

    /**
     * 加载数据的方法，由子类实现
     */
    @Override
    void initData() {
        final SwipeRefreshLayout swipeRefreshLayout = getView().findViewById(R.id.swifesh_lay);
        final TextView tv_data = getView().findViewById(R.id.tv_data);
        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv_data.setText("第二页数据加载成功...");
                swipeRefreshLayout.setRefreshing(false);
            }
        },1500);
    }

    /**
     * 设置Fragment target，由子类实现
     */
    @Override
    boolean setFragmentTarget() {
        return false;
    }


}
