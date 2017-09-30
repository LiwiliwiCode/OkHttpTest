package com.okhttptest.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.okhttptest.R;
import com.okhttptest.fragment.SoonShowFragment;
import com.okhttptest.fragment.UserFragment;
import com.okhttptest.fragment.WellReceivedFragment;
import com.okhttptest.service.BadgeIntentService;

import java.util.ArrayList;
import java.util.List;

import me.leolin.shortcutbadger.ShortcutBadger;


/**
 * 主界面
 */
public class MainActivity extends FragmentActivity {
    private Spinner mSpinner;
    private static final String TAG = "MainActivity";
    private Fragment mWellReceivedfragment; //0
    private Fragment mSoonShowfragment;//1
    private Fragment mUserfragment;//2
    private List<Fragment> fragments;
    private int showFragment = 0;//当前是显示fragment索引
    private TextView titleTv;
    private ComponentName mDefault;
    private ComponentName mDouble11;
    private ComponentName mDouble12;
    private PackageManager mPm;
    private ComponentName mDouble88;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (showFragment != 0) {
                        SwitchFragment(showFragment, 0);
                        titleTv.setText("正在热映");
                        showFragment = 0;
                    }
                    return true;
                case R.id.navigation_dashboard:

                    if (showFragment != 1) {
                        SwitchFragment(showFragment, 1);
                        titleTv.setText("即将上映");
                        showFragment = 1;
                    }
                    return true;

                case R.id.navigation_notifications:

                    if (showFragment != 2) {
                        SwitchFragment(showFragment, 2);
                        showFragment = 2;
                        titleTv.setText("我的");
                    }
                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTv = (TextView) findViewById(R.id.main_title);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//      BottomNavigationViewHelper.disableShiftMode(navigation);
        boolean success = ShortcutBadger.applyCount(MainActivity.this, 5);
        if(!success){
            startService(new Intent(MainActivity.this, BadgeIntentService.class).putExtra("badgeCount", 15));
        }
        Log.e(TAG,success+"");
        init();
        mSpinner = (Spinner)findViewById(R.id.main_spinner);
        List<String> list = new ArrayList<>();
        list.add("正常");
        list.add("双11");
        list.add("双12");
        list.add("8.8");
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        mSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        changeIcon();
                        break;
                    case 1:
                        changeIcon11();
                        break;
                    case 2:
                        changeIcon12();
                        break;
                    case 3:
                        changeIcon88();
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        initFragment();
        titleTv.setText("正在热映");
    }

    public void changeIcon11() {
        disableComponent(mDefault);
        disableComponent(mDouble12);
        disableComponent(mDouble88);
        enableComponent(mDouble11);
    }

    public void changeIcon12() {
        disableComponent(mDefault);
        disableComponent(mDouble11);
        disableComponent(mDouble88);
        enableComponent(mDouble12);
    }

    public void changeIcon88() {
        disableComponent(mDefault);
        disableComponent(mDouble11);
        disableComponent(mDouble12);
        enableComponent(mDouble88);
    }

    public void changeIcon() {
        disableComponent(mDouble88);
        disableComponent(mDouble11);
        disableComponent(mDouble12);
        enableComponent(mDefault);
    }

    private void enableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    private void disableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }


    private void init() {

        mDouble11 = new ComponentName(
                getBaseContext(),
                "com.okhttptest.Test11");
        mDouble12 = new ComponentName(
                getBaseContext(),
                "com.okhttptest.Test12");
        mDouble88 = new ComponentName(
                getBaseContext(),
                "com.okhttptest.Test88");
        mDefault = new ComponentName(
                getBaseContext(),"com.okhttptest.activity.HomeActivity");
        mPm = getApplicationContext().getPackageManager();

    }


    private void SwitchFragment(int from, int to) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments.get(from));
        Fragment fragment = fragments.get(to);
        if (!fragment.isAdded()) {
            transaction.add(R.id.content, fragment);
        }
        transaction.show(fragment).commitAllowingStateLoss();
    }

    private void initFragment() {
        showFragment = 0;
        fragments = new ArrayList<Fragment>();
        mWellReceivedfragment = new WellReceivedFragment();
        mSoonShowfragment = new SoonShowFragment();
        mUserfragment = new UserFragment();
        fragments.add(mWellReceivedfragment);
        fragments.add(mSoonShowfragment);
        fragments.add(mUserfragment);

        getSupportFragmentManager().beginTransaction().add(R.id.content, mWellReceivedfragment).show(mWellReceivedfragment).commit();
    }

    private long currentBackPressedTime = 0;
    // 退出间隔
    private static final int BACK_PRESSED_INTERVAL = 2000;

    @Override
    public void onBackPressed() {
        // 判断时间间隔
        if (System.currentTimeMillis() - currentBackPressedTime > BACK_PRESSED_INTERVAL) {
            currentBackPressedTime = System.currentTimeMillis();
            Toast.makeText(this, "再按一次返回键退出程序", Toast.LENGTH_SHORT).show();
        } else {
            // 退出
            finish();
        }
    }
}
