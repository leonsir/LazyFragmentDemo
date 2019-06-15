package com.lzy.lazyfragmentdemo.fragment;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.lzy.lazyfragmentdemo.R;
import java.util.ArrayList;
import java.util.List;
public class ThirdFragment  extends BaseFragmentTwo{
    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] titles={"Fragment_One","Fragment_Two","Fragment_Three"};
    /**
     * 由子类实现
     *
     * @return 返回子类的布局id
     */
    @Override
    int getLayoutId() {
        return R.layout.fragment_three;
    }
    /**
     * 加载数据的方法，由子类实现
     */
    @Override
    void initData() {
        initView();
    }

    /**
     * 设置Fragment target，由子类实现
     */
    @Override
    boolean setFragmentTarget() { return false; }


    private void initView(){
        ViewPager viewPager = getView().findViewById(R.id.vp_invest);
        TabLayout tableLayout = getView().findViewById(R.id.tab_layout);
        initFragments();
        MyAdapter adapter = new MyAdapter(getChildFragmentManager());//这里要用getChildFragmentManager()作为参数，如果用getFragmentManager()，那么子fragment在getParentFragment时就会为空
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
        //添加到集合中
        fragmentList.add(thirdOneFragment);
        fragmentList.add(thirdTwoFragment);
        fragmentList.add(thirdThreeFragment);
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
