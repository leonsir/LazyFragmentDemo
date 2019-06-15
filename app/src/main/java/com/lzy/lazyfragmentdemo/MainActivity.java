package com.lzy.lazyfragmentdemo;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.lzy.lazyfragmentdemo.fragment.FirstFragment;
import com.lzy.lazyfragmentdemo.fragment.FourthFragment;
import com.lzy.lazyfragmentdemo.fragment.SecondFragment;
import com.lzy.lazyfragmentdemo.fragment.ThirdFragment;
public class MainActivity extends FragmentActivity {

    private final int FIRST_SELECT_POSITION = 0;
    private final int SECOND_SELECT_POSITION = 1;
    private final int THIRD_SELECT_POSITION = 2;
    private final int FOURTH_SELECT_POSITION = 3;

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;
    private FourthFragment fourthFragment;
    private FragmentTransaction fragmentTransaction;
    private BottomNavigationBar bottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationBar = findViewById(R.id.bottom_navigation_bar_container);
        setBottomNavigationBar();
        setSelected(FIRST_SELECT_POSITION);
    }

    private void setBottomNavigationBar() {
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setActiveColor(R.color.BOTTOM_TEXT_COLOR)
                .addItem(new BottomNavigationItem(R.drawable.hometwo, getString(R.string.NAME_FIRAT_FRAGMENT))
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.drawable.home)))
                .addItem(new BottomNavigationItem(R.drawable.baogaotwo, getString(R.string.NAME_SECOND_FRAGMENT))
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.drawable.baogao)))
                .addItem(new BottomNavigationItem(R.drawable.messagetwo, getString(R.string.NAME_THIRD_FRAGMENT))
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.drawable.message)))
                .addItem(new BottomNavigationItem(R.drawable.minetwo, getString(R.string.NAME_FOURTH_FRAGMENT))
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.drawable.mine)))
                .setFirstSelectedPosition(FIRST_SELECT_POSITION)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {//未选中 -> 选中
                // Log.e("POSITOON",new Integer(position).toString());
                switch (position){
                    case FIRST_SELECT_POSITION:
                        setSelected(FIRST_SELECT_POSITION);
                        break;
                    case SECOND_SELECT_POSITION:
                        setSelected(SECOND_SELECT_POSITION);
                        break;
                    case THIRD_SELECT_POSITION:
                        setSelected(THIRD_SELECT_POSITION);
                        break;
                    case FOURTH_SELECT_POSITION:
                        setSelected(FOURTH_SELECT_POSITION);
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {//选中 -> 未选中
                switch (position){
                    case FIRST_SELECT_POSITION:
                        if(firstFragment != null){
                            fragmentTransaction.hide(firstFragment);
                            Log.e("隐藏",position+"------------");
                        }
                        break;
                    case SECOND_SELECT_POSITION:
                        if(secondFragment != null){
                            fragmentTransaction.hide(secondFragment);
                            Log.e("隐藏",position+"------------");
                        }
                        break;
                    case THIRD_SELECT_POSITION:
                        if(thirdFragment != null){
                            fragmentTransaction.hide(thirdFragment);
                            Log.e("隐藏",position+"------------");
                        }
                        break;
                    case FOURTH_SELECT_POSITION:
                        if(fourthFragment != null){
                            fragmentTransaction.hide(fourthFragment);
                            Log.e("隐藏",position+"------------");
                        }
                        break;
                }
            }
            @Override
            public void onTabReselected(int position) {//选中 -> 选中
            }
        });
    }


    //new fragment
    private void setSelected(int position){
        FragmentManager supportFragmentManager = this.getSupportFragmentManager();
        fragmentTransaction = supportFragmentManager.beginTransaction();
        //hideFragments();
        switch (position){
            case FIRST_SELECT_POSITION:
                if(firstFragment==null){
                    firstFragment=new FirstFragment();
                    fragmentTransaction.add(R.id.fl_main,firstFragment);
                }
                fragmentTransaction.show(firstFragment);
                break;
            case SECOND_SELECT_POSITION:
                if(secondFragment==null){
                    secondFragment=new SecondFragment();
                    fragmentTransaction.add(R.id.fl_main,secondFragment);
                }
                fragmentTransaction.show(secondFragment);
                break;
            case THIRD_SELECT_POSITION:
                if(thirdFragment==null){
                    thirdFragment=new ThirdFragment();
                    fragmentTransaction.add(R.id.fl_main,thirdFragment);
                }
                fragmentTransaction.show(thirdFragment);
                break;
            case FOURTH_SELECT_POSITION:
                if(fourthFragment==null){
                    fourthFragment=new FourthFragment();
                    fragmentTransaction.add(R.id.fl_main,fourthFragment);
                }
                fragmentTransaction.show(fourthFragment);
                break;
        }
        fragmentTransaction.commit();//提交事务
    }
}
