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
import android.widget.VideoView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.okhttptest.R;
import com.okhttptest.Util.LogUtils;
import com.okhttptest.bean.MoviecomingsBean;

import java.util.List;

/**
 * 影片详情
 * Created by hhmsw on 2017/9/21.
 */

public class SoonFlimDetailsActivity extends FragmentActivity {
    private static final String TAG = "FlimDetailsActivity";
    private MoviecomingsBean bean;
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
                MoviecomingsBean bean = (MoviecomingsBean) msg.obj;
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

            Bundle bundle = intent.getExtras();
            if(bundle != null){
                bean = (MoviecomingsBean) bundle.getSerializable("data");
                getDate();
            }
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
        Message msg = Message.obtain();
        msg.obj = bean;
        handler.sendMessageDelayed(msg,500);
    }

    /**
     * 将数据绑定到
     */
    private void BindViewsFromData(MoviecomingsBean flimbean){
        LogUtils.LogE(TAG,flimbean.toString());
        //影片图片
        image.setImageURI(flimbean.getImage());
        //影片名称
        mname.setText(flimbean.getTitle());
        //导演信息
        mdirector.setText("导演："+flimbean.getDirector());
        //上映时间
        mtime.setText(flimbean.getReleaseDate());
        //主角
        mis3D.setText("主演:"+flimbean.getActor1()+"/"+flimbean.getActor2());
        //产地
        mMins.setText(flimbean.getLocationName());
        //类型
        mtype.setText(flimbean.getType());
        //票房
//        mpiaofang.setText(flimbean.getData().getBoxOffice().getTotalBoxDes()+flimbean.getData().getBoxOffice().getTotalBoxUnit());
//        mpiaofang.setVisibility(View.GONE);
        mpiaofang.setText(flimbean.getWantedCount()+"人想看");
        //简介
//        mjianjie.setText(flimbean.getStory());
        mjianjie.setVisibility(View.GONE);
        //评分
//        mrating.setText("评分："+String.valueOf(flimbean.getOverallRating()));
        mrating.setText(flimbean.getRYear()+"");
        //演员别表
//        getchildView(flimbean.getActors());
        //预告片.MP4
            List<MoviecomingsBean.VideosBeanX> videos = flimbean.getVideos();
            if(videos != null){
                if(videos.size() < 1)
                    return;

                int index = 0;
                if(videos.size() > 1){
                    index = 1;
                }
                videoTitle.setText( videos.get(index).getTitle());
                video_image.setImageURI(videos.get(index).getImage());
                video_image_play.setTag(videos.get(index).getUrl());
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.e(TAG,"onBackPressed");
        finish();
    }
}
