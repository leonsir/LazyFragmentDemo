package com.lzy.lazyfragmentdemo.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lzy.lazyfragmentdemo.R;
import com.lzy.lazyfragmentdemo.SecondActivity;

public class FirstFragment extends BaseFragmentTwo {

    /**
     * 加载数据的方法，由子类实现
     */
    @Override
    void initData() {
        TextView tv_data = getView().findViewById(R.id.tv_data);
        Button btn_text = getView().findViewById(R.id.btn_text);
        tv_data.setText("加载第一页成功...");
        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),SecondActivity.class));
            }
        });

    }
    /**
     * 由子类实现
     *
     * @return 返回子类的布局id
     */
    @Override
    int getLayoutId() {
        return R.layout.fragment_one;
    }

    /**
     * 设置Fragment target，由子类实现
     */
    @Override
    boolean setFragmentTarget() { return false; }


}
