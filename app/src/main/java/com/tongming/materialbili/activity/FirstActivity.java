package com.tongming.materialbili.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


/**
 * Created by Tongming on 2016/3/18.
 */
public class FirstActivity extends Activity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
        boolean isFirstRun = sharedPreferences.getBoolean("isFirstRun", true);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (isFirstRun) {
            editor.putBoolean("isFirstRun", false);
            editor.putBoolean("isLogin", false);
            editor.apply();
            startActivity(new Intent(FirstActivity.this, GuidePageActivity.class));
        } else {
            startActivity(new Intent(FirstActivity.this, SplashActivity.class));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
