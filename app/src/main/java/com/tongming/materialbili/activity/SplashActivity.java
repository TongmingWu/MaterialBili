package com.tongming.materialbili.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.tongming.materialbili.R;
import com.tongming.materialbili.utils.LogUtil;
import com.tongming.materialbili.utils.TranslucentUtil;

/**
 * Created by Tongming on 2016/3/2.
 */
public class SplashActivity extends Activity {

    private Handler handler = new Handler();
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
        findViewById(R.id.rlRoot).setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        TranslucentUtil.translucentStatus(SplashActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //判断是否已经登录
                if (sharedPreferences.getBoolean("isLogin", true)) {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    //startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
            }
        }, 3000);
        LogUtil.i("sp",sharedPreferences+"");
    }

    @Override
    protected void onStop() {
        finish();
        super.onStop();
    }
}
