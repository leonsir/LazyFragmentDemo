package com.lzy.lazyfragmentdemo.fragment;
import android.widget.TextView;
import com.lzy.lazyfragmentdemo.R;

public class FourthFragment  extends BaseFragmentTwo{


    /**
     * 加载数据的方法，由子类实现
     */
    @Override
    void initData() {
        TextView tv_data = getView().findViewById(R.id.tv_data);
        tv_data.setText("加载最后一页成功...");

    }

    /**
     * 由子类实现
     *
     * @return 返回子类的布局id
     */
    @Override
    int getLayoutId() {
        return R.layout.fragment_four;
    }

    /**
     * 设置Fragment target，由子类实现
     */
    @Override
    boolean setFragmentTarget() { return false; }


}
