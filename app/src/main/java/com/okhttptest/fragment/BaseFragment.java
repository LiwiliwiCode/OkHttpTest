package com.okhttptest.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.okhttptest.Util.ConnectedUtil;
import com.okhttptest.Util.DialogUtil;

/**
 * Fragment基类，咨询、活动、我的均在这继承
 * Created by hhmsw on 2017/9/19.
 *
 */

public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(!ConnectedUtil.isMobileConnected()){
            DialogUtil.getIns().Tip(getActivity(),"请检查网络");
        }
       getFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
       });

        getDate();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return InitView(inflater.inflate(layoutID(),container,false));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    public abstract int layoutID();
    public abstract View InitView(View view);
    public abstract void getDate();
}
