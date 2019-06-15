package com.lzy.lazyfragmentdemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    private Boolean isInitData = false; //标志位,判断数据是否初始化
    private Boolean isVisibleToUser = false; //标志位,判断fragment是否可见
    private Boolean isPrepareView = false; //标志位,判断view已经加载完成 避免空指针操作

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(),container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isPrepareView=true;//此时view已经加载完成，设置其为true
    }
    /**
     * 懒加载方法
     */
    public void lazyInitData(){
        if(!isInitData && isVisibleToUser && isPrepareView){//如果数据还没有被加载过，并且fragment已经可见，view已经加载完成
            initData();//加载数据
            isInitData=true;//是否已经加载数据标志重新赋值为true
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser=isVisibleToUser;//将fragment是否可见值赋给标志isVisibleToUser
        lazyInitData();//加载懒加载
    }
    /**
     * fragment生命周期中onViewCreated之后的方法 在这里调用一次懒加载 避免第一次可见不加载数据
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lazyInitData();
    }
    /**
     * 由子类实现
     * @return 返回子类的布局id
      */
    abstract int getLayoutId();

    /**
     * 加载数据的方法，由子类实现
     */
    abstract void initData();
}
