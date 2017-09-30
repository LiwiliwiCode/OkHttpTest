package com.okhttptest.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.okhttptest.R;
import com.okhttptest.Util.ConnectedUtil;
import com.okhttptest.Util.DialogUtil;
import com.okhttptest.Util.LogUtils;
import com.okhttptest.Util.NetUtil;
import com.okhttptest.Util.Tools;
import com.okhttptest.bean.Flimbean;

import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * 影片详情
 * Created by hhmsw on 2017/9/21.
 */

public class FlimDetailsActivity extends FragmentActivity {
    private static final String TAG = "FlimDetailsActivity";
    private String movedId = null;
    private String locationId = null;
    private SwipeRefreshLayout mSwipe;
    private SimpleDraweeView image;
    private TextView mrating;
    private TextView mname;
    private TextView mdirector;
    private TextView mtime;
    private TextView mtype;
    private TextView mpiaofang;
    private TextView mjianjie;
    private LinearLayout yanyuan_content;
    private TextView videoTitle;
    private VideoView videoView;
    private MediaController mMediaController;
    private TextView mis3D;
    private TextView mMins;
    private SimpleDraweeView video_image;
    private Button video_image_play;
    private NestedScrollView nestedScrollview;


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.obj != null){
                DialogUtil.getIns().hideLoadingDialog();
                Flimbean bean = (Flimbean) msg.obj;
                BindViewsFromData(bean);
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flim_activity_layout);

        initViews();

        Intent intent = getIntent();
        if(intent != null){
             movedId = intent.getStringExtra("movedId");
             locationId = intent.getStringExtra("locationId");

            Log.e(TAG,movedId+"");
             getDate();
        }
    }



    private void initViews() {

         image = (SimpleDraweeView)findViewById(R.id.flim_desc_image);
         mrating = (TextView)findViewById(R.id.flim_desc_overallRating);
         mname = (TextView)findViewById(R.id.flim_desc_name);
         mdirector = (TextView)findViewById(R.id.flim_desc_director);
         mtime = (TextView)findViewById(R.id.flim_desc_time);
         mtype = (TextView)findViewById(R.id.flim_desc_type);
         mpiaofang = (TextView)findViewById(R.id.flim_desc_piaofang);
         mjianjie = (TextView)findViewById(R.id.flim_desc_jianjie);
         mis3D = (TextView)findViewById(R.id.flim_desc_3D);
         mMins = (TextView)findViewById(R.id.flim_desc_mins);
         yanyuan_content = (LinearLayout) findViewById(R.id.yanyuan_content);
         videoTitle = (TextView) findViewById(R.id.flim_video_title);
         videoView = (VideoView) findViewById(R.id.flim_videoview);
         video_image =(SimpleDraweeView)findViewById(R.id.video_image);
         video_image_play=(Button)findViewById(R.id.video_image_play);
         nestedScrollview = (NestedScrollView)findViewById(R.id.flim_desc_nestedScrollview);

         video_image_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.setVisibility(View.VISIBLE);
                video_image.setVisibility(View.GONE);
                video_image_play.setVisibility(View.GONE);
                String videourl = (String) v.getTag();
                loadView(videourl);
            }
        });

         mMediaController = new MediaController(this);
         videoView.setMediaController(mMediaController);

        mSwipe = (SwipeRefreshLayout)findViewById(R.id.flim_desc_swipeRefrensh);
        mSwipe.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDate();
                mSwipe.setRefreshing(false);
            }
        });


        nestedScrollview.getViewTreeObserver().addOnScrollChangedListener(new  ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                mSwipe.setEnabled(nestedScrollview.getScrollY()==0);
            }
        });
    }

    /**
     * 获取数据
     */
    private void getDate(){


                if(ConnectedUtil.isNetworkConnected()){
                    DialogUtil.getIns().showLoadingDialog(this);
                    RequestBody body = new FormBody.Builder().add("locationId",locationId)
                            .add("movieId",movedId).build();
                    try {
                       NetUtil.getInstance().post(Tools.FLIMDESC_URL, body, new NetUtil.NetCallback() {
                            @Override
                            public void Fail() {

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        DialogUtil.getIns().Tip(FlimDetailsActivity.this,"请检查当前网络");
                                        DialogUtil.getIns().hideLoadingDialog();
                                        LogUtils.LogE(TAG,"Fail");

                                    }
                                });

                            }

                            @Override
                            public void Success(String json) {
                                LogUtils.LogE(TAG,json);

                                    Flimbean flimbean = new Gson().fromJson(json,Flimbean.class);
                                    Message msg = Message.obtain();
                                    msg.obj = flimbean;
                                    handler.sendMessageDelayed(msg,1500);

                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(this, "看看网络好白...", Toast.LENGTH_SHORT).show();
                }
    }

    /**
     * 将数据绑定到
     */
    private void BindViewsFromData(Flimbean flimbean){
        LogUtils.LogE(TAG,flimbean.toString());
        Flimbean.DataBean.BasicBean bean = flimbean.getData().getBasic();
        //影片图片
        image.setImageURI(bean.getImg());
        //影片名称
        mname.setText(bean.getName());
        //导演信息
        mdirector.setText("导演："+bean.getDirector().getName());
        //上映时间
        mtime.setText(bean.getReleaseDate());
        //是否是3D
        mis3D.setText(bean.isIs3D() ? "3D":"2D");
        //影片长度
        mMins.setText("影片时长："+bean.getMins());
        //类型
        mtype.setText(bean.getType().toString());
        //票房
        mpiaofang.setText(flimbean.getData().getBoxOffice().getTotalBoxDes()+flimbean.getData().getBoxOffice().getTotalBoxUnit());
        //简介
        mjianjie.setText(bean.getStory());
        //评分
        mrating.setText("评分："+String.valueOf(bean.getOverallRating()));
        //演员别表
        getchildView(bean.getActors());
        //预告片.MP4
        Flimbean.DataBean.BasicBean.VideoBean video = bean.getVideo();
        if(video != null){
            LogUtils.LogE(TAG,video.getUrl());
            videoTitle.setText(video.getTitle());
            video_image.setImageURI(video.getImg());
            video_image_play.setTag(video.getUrl());
        }
    }


    public void loadView(String path) {
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //mp.setLooping(true);
                mp.start();// 播放

            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                video_image.setVisibility(View.VISIBLE);
                video_image_play.setVisibility(View.VISIBLE);
                videoView.setVisibility(View.INVISIBLE);

            }
        });
    }

    /**
     * 演员
     * @param actors
     */
    private void getchildView(List<Flimbean.DataBean.BasicBean.ActorsBean> actors) {
        int size = actors.size();
        yanyuan_content.removeAllViews();
        for (int i = 0; i < size; i++) {
            Flimbean.DataBean.BasicBean.ActorsBean actor = actors.get(i);
            View view = getLayoutInflater().inflate(R.layout.flim_desc_yanyuan_item,null,false);
            view.setPadding(0,0,15,0);
            SimpleDraweeView icon = (SimpleDraweeView)view.findViewById(R.id.flim_yanyuan_icon);
            TextView name = (TextView)view.findViewById(R.id.flim_yanyuan_name);
            TextView roleName = (TextView)view.findViewById(R.id.flim_yanyuan_roleName);
            icon.setImageURI(actor.getImg());
            name.setText(actor.getName());
            roleName.setText(actor.getRoleName());
            yanyuan_content.addView(view);
        }

    }
}
