package com.tongming.materialbili.presenter;

import android.os.Handler;
import android.os.Looper;

import com.tongming.materialbili.activity.ILoginView;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.utils.URLUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tongming on 2016/4/27.
 */
public class LoginPresenterCompl implements ILoginPresenter {
    private ILoginView mLoginView;
    private Handler mHandler;

    public LoginPresenterCompl(ILoginView loginView) {
        mLoginView = loginView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void getUid(String userid, String pwd, String vdcode) {
        OkHttpClient client = BaseApplication.client;

        FormBody formbody = new FormBody.Builder()
                .add("userid", userid)
                .add("pwd", pwd)
                .add("vdcode", vdcode)
                .build();
        Request request = new Request.Builder().url(URLUtil.PYTHON)
                .post(formbody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.onFailed();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String uid = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.onSuccess(uid);
                    }
                });
            }
        });
    }
}
