package com.tongming.materialbili.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.reflect.TypeToken;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.fragment.IAnimeView;
import com.tongming.materialbili.model.Bangumi;
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
public class AnimePresenterCompl implements IVideoPresenter {

    private static final String TAG = "Anime";
    private IAnimeView mAnimeView;
    private Handler mHandler ;

    public AnimePresenterCompl(IAnimeView animeView) {
        mAnimeView = animeView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void getVideo() {
        Request requestBangumi = new Request.Builder().url(URLUtil.BANGUMI).build();
        BaseApplication.client.newCall(requestBangumi).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "获取番剧信息失败");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                final Bangumi bangumi = BaseApplication.gson.fromJson(json,
                        new TypeToken<Bangumi>() {
                        }.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mAnimeView.onGetAnimeResult(bangumi);
                    }
                });
                LogUtil.i(TAG, "获取番剧数据成功");
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
                        mAnimeView.onGetBannerResult(indexBanner);
                    }
                });
                LogUtil.i(TAG, "获取banner数据成功");
            }
        });
    }
}
