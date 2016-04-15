package com.tongming.materialbili.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tongming.materialbili.R;

/**
 * Created by Tongming on 2016/3/18.
 */
public class GuidePageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
    }

    public void login(View view){
        startActivity(new Intent(GuidePageActivity.this, LoginActivity.class));
        finish();
    }

    public void skip(View view){
        startActivity(new Intent(GuidePageActivity.this,HomeActivity.class));
        finish();
    }
}
