package com.tongming.materialbili.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.reflect.TypeToken;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.fragment.IRecView;
import com.tongming.materialbili.model.HotVideo;
import com.tongming.materialbili.model.IndexBanner;
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
public class RecPresenterCompl implements IVideoPresenter {
    private static final String TAG = "Rec";
    private IRecView mRecView;
    private Handler mHandler;

    public RecPresenterCompl(IRecView recView) {
        mRecView = recView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void getVideo() {
        final Request requestVideo = new Request.Builder().url(URLUtil.HOT_VIEDO).build();
        BaseApplication.client.newCall(requestVideo).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.e(TAG, "获取hot失败数据失败");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final HotVideo hotVideo = BaseApplication.gson.fromJson(response.body().string(), new TypeToken<HotVideo>() {
                }.getType());
                LogUtil.i(TAG, "获取数据成功");
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mRecView.onGetVideoResult(hotVideo);
                    }
                });
            }
        });
    }

    @Override
    public void getBanner() {
        Request requestBanner = new Request.Builder().url(URLUtil.INDEXINFO).build();
        BaseApplication.client.newCall(requestBanner).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "获取banner失败");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                //只获取banner部分的json
                String jsonBanner = "{" + json.substring(
                        json.indexOf("\"banners\""),
                        json.indexOf("]")) + "]}";
                //LogUtil.i(TAG,jsonBanner);
                final IndexBanner indexBanner = BaseApplication.gson.fromJson(jsonBanner,
                        new TypeToken<IndexBanner>() {
                        }.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mRecView.onGetBannerResult(indexBanner);
                    }
                });
                LogUtil.i(TAG, "获取banner数据成功");
            }
        });
    }
}
