package com.tongming.materialbili.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.reflect.TypeToken;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.fragment.ILiveView;
import com.tongming.materialbili.model.LiveVideo;
import com.tongming.materialbili.utils.LogUtil;
import com.tongming.materialbili.utils.URLUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tongming on 2016/4/23.
 */
public class LivePresenterCompl implements IVideoPresenter{

    private static final String TAG = "Live";
    private Handler mHandler;
    ILiveView mLiveView;
    public LivePresenterCompl(ILiveView mLiveView) {
        this.mLiveView = mLiveView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void getVideo() {
        Request requestLive = new Request.Builder().url(URLUtil.LIVEINFO).build();
        BaseApplication.client.newCall(requestLive).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                final LiveVideo live = BaseApplication.gson.fromJson(json,
                        new TypeToken<LiveVideo>() {
                        }.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLiveView.onGetLiveResult(live);
                    }
                });
                LogUtil.i(TAG,"获取直播数据成功");
            }
        });
    }

    @Override
    public void getBanner() {

    }
}
