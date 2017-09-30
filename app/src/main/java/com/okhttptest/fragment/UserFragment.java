package com.okhttptest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.okhttptest.R;
import com.okhttptest.Util.Tools;

/**
 * 我的界面
 * Created by hhmsw on 2017/9/19.
 */

public class UserFragment extends BaseFragment {
    private SimpleDraweeView useIcon;
    private static final String TAG = "UserFragment";
    private TextView msgTv;
    @Override
    public int layoutID() {
        return R.layout.user_fragment;
    }

    @Override
    public View InitView(View view) {
        useIcon = (SimpleDraweeView)view.findViewById(R.id.user_icon);
        msgTv = (TextView) view.findViewById(R.id.user_message);

        return view;
    }

    @Override
    public void getDate() {
        Log.e(TAG, "getDate: ");

        useIcon.setImageURI(Tools.picPath[0]);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
    }
}
