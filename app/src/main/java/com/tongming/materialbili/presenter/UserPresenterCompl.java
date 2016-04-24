package com.tongming.materialbili.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.reflect.TypeToken;
import com.tongming.materialbili.activity.IUserView;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.model.User;
import com.tongming.materialbili.utils.LogUtil;
import com.tongming.materialbili.utils.URLUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tongming on 2016/4/24.
 */
public class UserPresenterCompl implements IUserPresenter {

    private static final String TAG = "User";
    private IUserView mUserView;
    private Handler mHandler;

    public UserPresenterCompl(IUserView userView) {
        mUserView = userView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void getUserInfo() {
        final Request requestVideo = new Request.Builder().url(URLUtil.USER).build();
        BaseApplication.client.newCall(requestVideo).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.e(TAG, "获取用户数据失败");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final User user = BaseApplication.gson.fromJson(response.body().string(), new TypeToken<User>() {
                }.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserView.onGetUserInfo(user);
                    }
                });
                LogUtil.i(TAG, "获取用户数据成功");
            }
        });
    }
}
