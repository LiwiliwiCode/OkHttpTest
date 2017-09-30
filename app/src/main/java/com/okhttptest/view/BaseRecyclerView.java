package com.okhttptest.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.okhttptest.Util.LogUtils;

/**
 * BaseRecyclerView
 * Created by hhmsw on 2017/9/21.
 */

public class BaseRecyclerView extends android.support.v7.widget.RecyclerView {
    private static final String TAG = "BaseRecyclerView";
    private View emptyView;
    AdapterDataObserver observer = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            checkIfEmpty();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            checkIfEmpty();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            checkIfEmpty();
        }
    };

    @Override
    public void setAdapter(Adapter adapter) {
        Adapter oldAdapter = getAdapter();
        if (oldAdapter != null) {
            oldAdapter.unregisterAdapterDataObserver(observer);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(observer);
        }
    }


    public BaseRecyclerView(Context context) {
        super(context);
    }

    public BaseRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseRecyclerView(Context context, AttributeSet attrs,
                            int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
    }

    public void checkIfEmpty() {

        if (emptyView != null && getAdapter() != null) {
            LogUtils.LogE(TAG,"checkIfEmpty");
            final boolean emptyViewVisible =
                    getAdapter().getItemCount() == 0;
            LogUtils.LogE(TAG,"emptyViewVisible"+emptyViewVisible);
            emptyView.setVisibility(emptyViewVisible ? VISIBLE : GONE);
            setVisibility(emptyViewVisible ? GONE : VISIBLE);
        }
    }

}
