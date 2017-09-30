package com.okhttptest.Util;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.okhttptest.R;

/**
 * Created by hhmsw on 2017/9/26.
 */

public class DialogUtil {
    private ProgressDialog mPregressDialog;

    private DialogUtil() {
    }

    /**
     * 手机未在Wifi时，加载数据给予提醒
     */
    public void Tip(Context context,String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    private static class DialogUtilFactory {
        private static DialogUtil dialogUtil = new DialogUtil();
    }

    public static DialogUtil getIns() {
        return DialogUtilFactory.dialogUtil;
    }

    /**
     * 加载对话框
     */
    public void showLoadingDialog(Context context) {

        View dialog = LayoutInflater.from(context).inflate(R.layout.loading_dialog, null);
        mPregressDialog = ProgressDialog.show(context, "", "");
        mPregressDialog.setContentView(dialog);
//        mPregressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 设置进度条的形式为圆形转动的进度条
        mPregressDialog.setCancelable(true);// 设置是否可以通过点击Back键取消
        mPregressDialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
        mPregressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        if (mPregressDialog.getWindow() != null) {
            WindowManager.LayoutParams params = mPregressDialog.getWindow().getAttributes();
            params.width = (int) (130 * (context.getResources().getDisplayMetrics().density) + 0.5f);
            params.height = (int) (130 * (context.getResources().getDisplayMetrics().density) + 0.5f);
            mPregressDialog.getWindow().setAttributes(params);
        }
    }

    public void hideLoadingDialog() {
        if(mPregressDialog.isShowing()){
            mPregressDialog.dismiss();
        }
    }

}
