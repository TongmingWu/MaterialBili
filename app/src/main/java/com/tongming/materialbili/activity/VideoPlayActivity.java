package com.tongming.materialbili.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.tongming.materialbili.R;
import com.tongming.materialbili.base.BaseFragment;
import com.tongming.materialbili.fragment.ProfileFragment;
import com.tongming.materialbili.fragment.ReviewFragment;
import com.tongming.materialbili.model.AidVideo;
import com.tongming.materialbili.model.VideoUrl;
import com.tongming.materialbili.network.DoRequest;
import com.tongming.materialbili.player.GiraffePlayer;
import com.tongming.materialbili.utils.LogUtil;
import com.tongming.materialbili.utils.URLUtil;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tongming on 2016/3/20.
 */
public class VideoPlayActivity extends FragmentActivity {

    private static final String TAG = "Play";
    private GiraffePlayer player;
    private ViewPager vp_video;
    //页面List
    private List<BaseFragment> fragmentList = new ArrayList<>();
    //页面title
    private List<String> titleList = new ArrayList<>();
    private TabLayout tabLayout;
    private String review;

    private FloatingActionButton fab_video;
    private static Bundle bundle;
    private String url;
    private AidVideo video;
    private LinearLayout rl_player;
    private AppBarLayout appbar;

    private static Handler mHandler;
    private static Handler reviewHandler;
    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Bundle msgBundle = msg.getData();
                    String cid = msgBundle.getString("cid");
                    video = msgBundle.getParcelable("video");
                    initPlayer();
                    initViewPager();
                    Message rMsg = reviewHandler.obtainMessage();
                    rMsg.what = 0;
                    rMsg.obj = aid;
                    reviewHandler.sendMessage(rMsg);
                    Message fMsg = mHandler.obtainMessage();
                    fMsg.what = 0;
                    fMsg.obj = video;
                    mHandler.sendMessage(fMsg);
                    DoRequest.getUrl(cid, handler);
                    break;
                case 1:
                    VideoUrl videoUrl = (VideoUrl) msg.obj;
                    url = videoUrl.getUrl();
                    mRlLater.setVisibility(View.GONE);
                    break;
                case 2:
                    //获取弹幕文件成功
                    InputStream stream = (InputStream) msg.obj;
                    player.play(VideoPlayActivity.this.url, stream);
                    fab_video.setVisibility(View.GONE);
                    break;
                case 3:
                    //获取弹幕文件失败
                    player.play(VideoPlayActivity.this.url);
                    fab_video.setVisibility(View.GONE);
                    break;
            }
        }
    };
    private RelativeLayout mRlLater;
    private String aid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_inner);
        //TranslucentUtil.translucentNavigation(VideoPlayActivity.this);
        vp_video = (ViewPager) findViewById(R.id.vp_video);
        fab_video = (FloatingActionButton) findViewById(R.id.fab_play);
        initData();
        initView();
        playVideo();
    }

    //播放视频
    private void playVideo() {
        final Animation fabAnimation = AnimationUtils.loadAnimation(this, R.anim.design_fab);
        fab_video.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    doRequest();
                    fab_video.startAnimation(fabAnimation);
                    return true;
                }
                return true;
            }
        });
    }


    private void doRequest() {
        String danmaku = URLUtil.getDanmaku(bundle.getString("cid"));
        LogUtil.i(TAG, danmaku);
        //获取弹幕文件
        DoRequest.getDanmaku(danmaku, handler);
    }

    //初始化播放器
    private void initPlayer() {
        player = new GiraffePlayer(VideoPlayActivity.this);
        player.setTitle(video.getTitle());
    }

    public void setHandler(Handler handler) {
        mHandler = handler;
    }
    public void setReviewHandler(Handler handler) {
        reviewHandler = handler;
    }

    private void initData() {
        Intent intent = getIntent();
        bundle = intent.getExtras();
        aid = bundle.getString("aid");
        DoRequest.getCid(aid, handler);
    }

    private void initView() {
        //initViewPager();
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        rl_player = (LinearLayout) findViewById(R.id.rl_player);
        tabLayout = (TabLayout) findViewById(R.id.tl_video);
        mRlLater = (RelativeLayout) findViewById(R.id.rl_later);
    }

    private void initViewPager() {
        fragmentList.add(new ProfileFragment());
        fragmentList.add(new ReviewFragment());
        titleList.add("简介");
        titleList.add("评论(" + video.getReview() + ")");
        vp_video.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        tabLayout.setupWithViewPager(vp_video);
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
        if (width > height) {
            rl_player.setVisibility(View.GONE);
            player.setFullScreenOnly(true);
            CoordinatorLayout.LayoutParams params = new CoordinatorLayout.LayoutParams(
                    CoordinatorLayout.LayoutParams.MATCH_PARENT,
                    CoordinatorLayout.LayoutParams.MATCH_PARENT
            );
            appbar.setLayoutParams(params);
            appbar.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        } else {
            CoordinatorLayout.LayoutParams params = new CoordinatorLayout.LayoutParams(
                    CoordinatorLayout.LayoutParams.MATCH_PARENT,
                    appWidth
            );
            appbar.setLayoutParams(params);
            player.setFullScreenOnly(false);
            rl_player.setVisibility(View.VISIBLE);
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
                CoordinatorLayout.LayoutParams params = new CoordinatorLayout.LayoutParams(
                        CoordinatorLayout.LayoutParams.MATCH_PARENT,
                        appWidth
                );
                appbar.setLayoutParams(params);
                //player.setFullScreenOnly(false);
                this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                rl_player.setVisibility(View.VISIBLE);
                LogUtil.i(TAG, "执行了");
                return false;
            } else {
                onBackPressed();
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
