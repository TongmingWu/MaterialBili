package com.tongming.materialbili.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tongming.materialbili.R;
import com.tongming.materialbili.model.LiveVideo;
import com.tongming.materialbili.network.DoRequest;
import com.tongming.materialbili.player.GiraffePlayer;
import com.tongming.materialbili.utils.LogUtil;
import com.tongming.materialbili.CusView.GlideGircleTransform;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tongming on 2016/4/7.
 */
public class LivePlayActivity extends AppCompatActivity {

    private final String TAG = "LivePlay";
    private TabLayout tabLayout;
    private GiraffePlayer player;
    private List<String> titleList = new ArrayList<>();
    private ImageView iv_face;
    private TextView tv_author;
    private TextView tv_online;
    private TextView tv_title;

    private Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    String url = (String) msg.obj;
                    player.play(url);
            }
        }
    };
    private LinearLayout rl_gone;
    private RelativeLayout include;
    private LiveVideo.DataEntity.PartitionsEntity.LivesEntity live;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.live_inner);
        //TranslucentUtil.translucentNavigation(LivePlayActivity.this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        live = bundle.getParcelable("live");
        DoRequest.getLiveUrl(live.getRoom_id()+"",handler);
        initView();
        initData();
        initPlayer();
    }

    private void initView(){
        tabLayout = (TabLayout) findViewById(R.id.tab_live);
        include = (RelativeLayout) findViewById(R.id.rl_include);
        rl_gone = (LinearLayout) findViewById(R.id.rl_gone);
        tv_author = (TextView) findViewById(R.id.live_inner_author);
        iv_face = (ImageView) findViewById(R.id.iv_face);
        tv_online = (TextView) findViewById(R.id.online_num);
        tv_title = (TextView) findViewById(R.id.live_inner_title);
    }

    private void initData(){
        titleList.add("互动");
        titleList.add("评议会");
        titleList.add("投喂榜");
        titleList.add("粉丝榜");


        for(int i = 0;i<titleList.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(titleList.get(i)));
        }
        tv_author.setText(live.getOwner().getName());
        tv_online.setText(live.getOnline()+"");
        tv_title.setText(live.getTitle());
        Glide.with(this).load(live.getOwner().getFace()).transform(new GlideGircleTransform(this)).into(iv_face);
    }

    //初始化播放器
    private void initPlayer() {
        player = new GiraffePlayer(this);
        player.setTitle(live.getTitle());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        int appWidth = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 210, getResources().getDisplayMetrics()
        );
        LogUtil.i("Play", "执行了");
        if (width > height) {
            rl_gone.setVisibility(View.GONE);
            player.setFullScreenOnly(true);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            );
            include.setLayoutParams(params);
            include.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }else {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    appWidth
            );
            include.setLayoutParams(params);
            player.setFullScreenOnly(false);
            rl_gone.setVisibility(View.VISIBLE);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Display display = getWindowManager().getDefaultDisplay();
            int width = display.getWidth();
            int height = display.getHeight();
            int appWidth = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 210, getResources().getDisplayMetrics()
            );
            if (width > height) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        appWidth
                );
                include.setLayoutParams(params);
                //player.setFullScreenOnly(false);
                this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                rl_gone.setVisibility(View.VISIBLE);
                LogUtil.i("Play", "执行了");
                return false;
            }else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            player.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
        if (player != null) {
            player.onDestroy();
        }
    }

}
