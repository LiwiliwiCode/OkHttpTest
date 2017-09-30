package com.okhttptest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.okhttptest.R;
import com.okhttptest.Util.Tools;
import com.okhttptest.fragment.NavigationPicFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 导航
 * Created by hhmsw on 2017/9/19.
 */

public class NavigationActivity extends FragmentActivity{
    private String TAG = NavigationActivity.class.getSimpleName();
    private ViewPager navigation_viewpager;
    private LinearLayout docimage_bg;
    private List<ImageView> docImages = new ArrayList<ImageView>();
    private List<Fragment> fragments = new ArrayList<Fragment>();
    private int urllength;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_layout);
        docimage_bg = (LinearLayout) findViewById(R.id.docimage_bg);
        navigation_viewpager = (ViewPager) findViewById(R.id.navigation_viewpager);

        urllength = Tools.picPath.length;
        //初始化分页码
        Initdoc(urllength);

        for (int i = 0; i < urllength ; i++) {
            fragments.add(NavigationPicFragment.newInstance(Tools.picPath[i]));
        }

        navigation_viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        navigation_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                docRestore();
                docSelect(position);

                if(position == urllength -1){
                    //显示进入按钮
                    NavigationPicFragment gragment = (NavigationPicFragment) fragments.get(position);
                    gragment.show();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /**
     * 根据position 为分页码设置选中状态
     * @param position
     */
    private void docSelect(int position) {
        ImageView imageview = docImages.get(position);
        imageview.setLayoutParams(new LinearLayout.LayoutParams(30,30));
        imageview.setImageResource(R.mipmap.navigation_doc_select);
    }


    /**
     * 底部分页码状态还原
     */
    private void docRestore() {
        int size = docImages.size();
        for (int i = 0; i < size; i++) {
            ImageView imageview = docImages.get(i);
            imageview.setLayoutParams(new LinearLayout.LayoutParams(25,25));
            imageview.setImageResource(R.mipmap.navigation_doc_normol);
        }
    }


    /**
     * 根据请求的图片动态设置底部 分页码
     * @param length
     */
    private void Initdoc(int length) {

        for (int i = 0; i <length ; i++) {
            ImageView imageview = new ImageView(NavigationActivity.this);

            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setLayoutParams(new LinearLayout.LayoutParams(25,25));
            if(i == 0){
                imageview.setPadding(5,0,5,0);
                imageview.setLayoutParams(new LinearLayout.LayoutParams(30,30));
                imageview.setImageResource(R.mipmap.navigation_doc_select);
            }else{
                imageview.setPadding(0,0,5,0);
                imageview.setImageResource(R.mipmap.navigation_doc_normol);
            }
            docImages.add(imageview);
            docimage_bg.addView(imageview);
        }
    }



}
