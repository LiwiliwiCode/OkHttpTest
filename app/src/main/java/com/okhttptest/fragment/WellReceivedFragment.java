package com.okhttptest.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.okhttptest.Cache.LruJsonCache;
import com.okhttptest.R;
import com.okhttptest.Util.ConnectedUtil;
import com.okhttptest.Util.DialogUtil;
import com.okhttptest.Util.LogUtils;
import com.okhttptest.Util.LoginUtil;
import com.okhttptest.Util.NetUtil;
import com.okhttptest.Util.Tools;
import com.okhttptest.activity.FlimDetailsActivity;
import com.okhttptest.activity.LoginActivity;
import com.okhttptest.bean.WellRecevicebean;
import com.okhttptest.view.BaseRecyclerView;
import com.okhttptest.view.WellReceivedAdapter;

import java.io.IOException;

/**
 * 影片正在热映
 * Created by hhmsw on 2017/9/19.
 */

public class WellReceivedFragment extends BaseFragment {
    private static final String TAG = "WellReceivedFragment";
    private BaseRecyclerView mRecyclerView = null;
    private WellReceivedAdapter mRecyclerAdapter = null;
    private SwipeRefreshLayout mSwipeRefrensh;
    private LinearLayout mEmtryView ;
    @Override
    public int layoutID() {
        return R.layout.well_fragment;
    }

    @Override
    public View InitView(View view) {
        mRecyclerView = (BaseRecyclerView) view.findViewById(R.id.zixunRecyckerView);
        mEmtryView = (LinearLayout)view.findViewById(R.id.empty_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerAdapter = new WellReceivedAdapter(getActivity(), new WellReceivedAdapter.ReceivedAdapterCallback() {
            @Override
            public void Refrensh() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogUtil.getIns().hideLoadingDialog();
                        mRecyclerAdapter.notifyDataSetChanged();
                    }
                });
            }
        });

        mRecyclerAdapter.setOnItemOnClickListener(new WellReceivedAdapter.ItemOnClickListener() {
            @Override
            public void onClickListener(int moveId) {
              if(!LoginUtil.isLogin()){
                  Intent intent = new Intent(getActivity(), LoginActivity.class);
                  getActivity().startActivity(intent);
              }else{
                  Intent intent = new Intent(getActivity(), FlimDetailsActivity.class);
                  intent.putExtra("movedId", moveId + "");
                  intent.putExtra("locationId", 290 + "");
                  getActivity().startActivity(intent);
              }
            }
        });

        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setEmptyView(mEmtryView);

        mSwipeRefrensh = (SwipeRefreshLayout) view.findViewById(R.id.well_swipe);
        mSwipeRefrensh.setProgressBackgroundColorSchemeResource(android.R.color.white);
        mSwipeRefrensh.setProgressViewOffset(false, 0, 100);
        // 设置下拉进度的主题颜色
        mSwipeRefrensh.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        mSwipeRefrensh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDate();
                mSwipeRefrensh.setRefreshing(false);

            }
        });

        return view;
    }

    /**
     * 获取数据
     */
    @Override
    public void getDate() {
        LogUtils.LogE(TAG, "getDate");
        DialogUtil.getIns().showLoadingDialog(getActivity());

        try {
            String json = null;
            if(!ConnectedUtil.isNetworkConnected()){
                json = LruJsonCache.getLruJsonCache().GetJson(Tools.WELLRE_URL);
                LogUtils.LogE(TAG, "cachejson =" + json);
                WellRecevicebean well = new Gson().fromJson(json, WellRecevicebean.class);
                mRecyclerAdapter.addData(well.getMs());
            }else{
                NetUtil.getInstance().Get(Tools.WELLRE_URL, new NetUtil.NetCallback() {
                    @Override
                    public void Fail() {
                        LogUtils.LogE(TAG, "Fail" );
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                DialogUtil.getIns().Tip(getActivity(),"请检查当前网络");

                                mRecyclerAdapter.addData(null);

                            }
                        });
                    }

                    @Override
                    public void Success(String json) {
                        LogUtils.LogE(TAG, "addJson =" + json);
                        WellRecevicebean well = new Gson().fromJson(json, WellRecevicebean.class);
                        mRecyclerAdapter.addData(well.getMs());
                        LruJsonCache.getLruJsonCache().addJson(Tools.WELLRE_URL,json);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.LogE(TAG,"onCreate");
    }
}
