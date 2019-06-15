package com.lzy.lazyfragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.lzy.lazyfragmentdemo.fragment.SecondFourFragment;
import com.lzy.lazyfragmentdemo.fragment.SecondOneFragment;
import com.lzy.lazyfragmentdemo.fragment.SecondThreeFragment;
import com.lzy.lazyfragmentdemo.fragment.SecondTwoFragment;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends FragmentActivity {
    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] titles={"Fragment_One","Fragment_Two","Fragment_Three","Fragment_Four"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
    }


    private void initView(){
        ViewPager viewPager = findViewById(R.id.vp_invest);
        TabLayout tableLayout = findViewById(R.id.tab_layout);
        initFragments();  //初始化fragments
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(fragmentList.size());
        viewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(viewPager);

    }
    /**
     * 初始化fragments
     */
    private void initFragments() {
        SecondOneFragment thirdOneFragment = new SecondOneFragment();
        SecondTwoFragment thirdTwoFragment = new SecondTwoFragment();
        SecondThreeFragment thirdThreeFragment = new SecondThreeFragment();
        SecondFourFragment secondFourFragment = new SecondFourFragment();
        //添加到集合中
        fragmentList.add(thirdOneFragment);
        fragmentList.add(thirdTwoFragment);
        fragmentList.add(thirdThreeFragment);
        fragmentList.add(secondFourFragment);
    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        /**
         * Return the Fragment associated with a specified position.
         *
         * @param position
         */
        @Override
        public Fragment getItem(int position) { return fragmentList.get(position); }

        @Override
        public int getCount() { return fragmentList == null ? 0 : fragmentList.size(); }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) { return titles[position]; }
    }
}
