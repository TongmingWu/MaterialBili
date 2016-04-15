package com.tongming.materialbili.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tongming.materialbili.R;
import com.tongming.materialbili.model.AidVideo;
import com.tongming.materialbili.model.VideoUrl;
import com.tongming.materialbili.network.DoRequest;

/**
 * 在视频地址没加载完成之前显示这个页面
 * Created by Tongming on 2016/3/22.
 */
public class VideoPreActivity extends AppCompatActivity {

    private Bundle bundle;
    private String cid;
    private VideoUrl url;
    private AidVideo video;
    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Bundle msgBundle = msg.getData();
                    cid = msgBundle.getString("cid");
                    video = msgBundle.getParcelable("video");
                    DoRequest.getUrl(cid,handler);
                    break;
                case 1:
                    Intent intent = new Intent(VideoPreActivity.this, VideoPlayActivity.class);
                    url = (VideoUrl) msg.obj;
                    bundle.putString("urlVideo", url.getUrl());
                    bundle.putParcelable("video", video);
                    bundle.putString("cid", cid);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_video_inner);
        Intent intent = getIntent();
        bundle = intent.getExtras();
        initData();
    }


    private void initData() {
        String aid = bundle.getString("aid");
        DoRequest.getCid(aid,handler);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
