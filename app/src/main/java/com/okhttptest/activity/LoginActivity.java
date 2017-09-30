package com.okhttptest.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.okhttptest.R;
import com.okhttptest.Util.LoginUtil;

import org.json.JSONObject;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * Created by hhmsw on 2017/9/28.
 */

public class LoginActivity extends Activity {
    private EditText phoneEdit = null;
    private EditText code;
    private Button obtainCode;
    private static final String TAG = "LoginActivity";
    private int SMSDDK_HANDLER = 1001;
    private TextView textView6;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(msg == null)
                return;

            int event = msg.arg1;
            int result = msg.arg2;
            Object data = msg.obj;
            //回调完成
            if (result == SMSSDK.RESULT_COMPLETE)
            {
                //验证码验证成功
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE)
                {
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                    LoginUtil.setlogin();
                    LoginActivity.this.finish();
                }
                //已发送验证码
                else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE)
                {
                    Toast.makeText(getApplicationContext(), "验证码已经发送",
                            Toast.LENGTH_SHORT).show();
                } else
                {
                    ((Throwable) data).printStackTrace();
                }
            }
            if(result==SMSSDK.RESULT_ERROR)
            {
                try {
                    Throwable throwable = (Throwable) data;
                    throwable.printStackTrace();
                    JSONObject object = new JSONObject(throwable.getMessage());
                    String des = object.optString("detail");//错误描述
                    int status = object.optInt("status");//错误代码
                    if (status > 0 && !TextUtils.isEmpty(des)) {
                        Toast.makeText(getApplicationContext(), des, Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (Exception e) {
                    //do something
                }
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        phoneEdit = (EditText)findViewById(R.id.login_phone);
        code = (EditText)findViewById(R.id.login_code);
        obtainCode = (Button) findViewById(R.id.login_obtaincodebt);

        textView6 = (TextView)findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "别瞎点，好不好！", Toast.LENGTH_SHORT).show();
            }
        });
        obtainCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtainCode();
            }
        });

        EventHandler eventHandler = new EventHandler() {
        @Override
        public void afterEvent(int event, int result, Object data) {
        Message msg = new Message();
        msg.arg1 = event;
        msg.arg2 = result;
        msg.obj = data;
        msg.what = SMSDDK_HANDLER;
        handler.sendMessage(msg);
        }};
       // 注册回调监听接口
      SMSSDK.registerEventHandler(eventHandler);
    }

    /**
     * 登录
     * @param v
     */
    public void login(View v){

        SMSSDK.submitVerificationCode("86", phoneEdit.getText().toString(), code.getText()
                .toString());
    }

    /**
     * 获取验证码
     */
    public void obtainCode(){

        if(TextUtils.isEmpty(phoneEdit.getText().toString())){
            Toast.makeText(this, "你不写号码，你想干啥??", Toast.LENGTH_SHORT).show();
            return;
        }

        final String userPhone = phoneEdit.getText().toString();
        new AlertDialog.Builder(this).setMessage("确定要向"+userPhone+" 号码发送验证码？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new CountDownTimer(60000,1000){
                            @Override
                            public void onTick(long millisUntilFinished) {
                                Log.e(TAG,millisUntilFinished+"");
                                obtainCode.setText("等待验证码"+millisUntilFinished/1000+"s");
                            }

                            @Override
                            public void onFinish() {
                                obtainCode.setText("重新获取");
                            }
                        }.start();

                        SMSSDK.getVerificationCode("86", userPhone);
                    }
                }).setNegativeButton("取消",null).create().show();

    }


}
