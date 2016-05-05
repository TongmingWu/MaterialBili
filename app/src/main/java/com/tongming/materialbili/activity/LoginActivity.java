package com.tongming.materialbili.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.tongming.materialbili.R;
import com.tongming.materialbili.presenter.LoginPresenterCompl;
import com.tongming.materialbili.utils.LoadNetImage;
import com.tongming.materialbili.utils.LogUtil;
import com.tongming.materialbili.utils.ToastUtil;
import com.tongming.materialbili.utils.URLUtil;

/**
 * Created by Tongming on 2016/3/18.
 */
public class LoginActivity extends Activity implements ILoginView{

    private static final String TAG = "Login";
    private final String vdUrl = "https://passport.bilibili.com/captcha";
    private ImageView iv_vdcode;
    private EditText et_pwd;
    private ImageView iv_22;
    private ImageView iv_33;
    private EditText et_account;
    private EditText et_vd;
    private String vdcode;
    private String pwd;
    private String account;

    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Bitmap bitmap = (Bitmap) msg.obj;
                    iv_vdcode.setImageBitmap(bitmap);
                    break;
            }
        }
    };
    private SharedPreferences sharedPreferences;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
        iv_vdcode = (ImageView) findViewById(R.id.vdcode);
        iv_22 = (ImageView) findViewById(R.id.iv_22);
        iv_33 = (ImageView) findViewById(R.id.iv_33);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        et_account = (EditText) findViewById(R.id.et_account);
        et_account.setText(sharedPreferences.getString("userid", ""));
        et_vd = (EditText) findViewById(R.id.et_vd);
        initView();
    }

    private void initData() {
        account = et_account.getText().toString();
        sharedPreferences.edit().putString("userid", account).apply();
        pwd = et_pwd.getText().toString();
        vdcode = et_vd.getText().toString();
    }

    private void initView() {
        //密码框获得焦点的时候切换图片
        et_pwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    iv_22.setImageResource(R.drawable.ic_22_hide);
                    iv_33.setImageResource(R.drawable.ic_33_hide);
                } else {
                    iv_22.setImageResource(R.drawable.ic_22);
                    iv_33.setImageResource(R.drawable.ic_33);
                }
            }
        });
        iv_vdcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadNetImage.getVd(URLUtil.CAPTCHA, handler);
            }
        });
        LoadNetImage.getVd(vdUrl, handler);
    }

    public void login(View view) {
        initData();
        if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(pwd) && !TextUtils.isEmpty(vdcode)) {
            //第三方登录b站
            //LoginBilibili.okLogin(account, pwd, vdcode);
            LoginPresenterCompl loginPresenterCompl = new LoginPresenterCompl(this);
            loginPresenterCompl.getUid(account,pwd,vdcode);
            mDialog = new ProgressDialog(this);
            mDialog.setMessage("登录中...");
            mDialog.show();
        }

    }


    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public void onSuccess(String uid) {
        LogUtil.i(TAG,uid);
        mDialog.dismiss();
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("uid",uid);
        bundle.putString("classID","Login");
        intent.putExtras(bundle);
        startActivity(intent);
        sharedPreferences.edit().putBoolean("isLogin", true).apply();
        sharedPreferences.edit().putString("uid",uid).apply();
    }

    @Override
    public void onFailed(int code) {
        mDialog.dismiss();
        ToastUtil.showToast(this,"登录失败,请重新登录");
        LoadNetImage.getVd(vdUrl, handler);
    }
}
