package com.tongming.materialbili.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.reflect.TypeToken;
import com.tongming.materialbili.activity.IVideoPlayView;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.model.AidVideo;
import com.tongming.materialbili.model.VideoUrl;
import com.tongming.materialbili.utils.LogUtil;
import com.tongming.materialbili.utils.URLUtil;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tongming on 2016/4/23.
 */
public class VideoPlayPresenterCompl implements IPlayPresenter {
    private static final String TAG = "Play";
    private IVideoPlayView mPlayView;
    private Handler mHandler;

    public VideoPlayPresenterCompl(IVideoPlayView playView) {
        mPlayView = playView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void getInfo(String aid) {
        Request requestVideo = new Request.Builder().url(URLUtil.INFO_VIEDO + aid).build();
        BaseApplication.client.newCall(requestVideo).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i("URL", "获取cid失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                final AidVideo video = BaseApplication.gson.fromJson(json, new TypeToken<AidVideo>() {
                }.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mPlayView.onGetVideoInfo(video);
                    }
                });
            }
        });
    }

    @Override
    public void getUrl(String cid) {
        Request requestUrl = new Request.Builder().url(URLUtil.VIDEODOWNLOAD + cid).build();
        BaseApplication.client.newCall(requestUrl).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i("URL", "获取视频下载地址失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                final VideoUrl url = BaseApplication.gson.fromJson(json, new TypeToken<VideoUrl>() {
                }.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mPlayView.onGetUrl(url);
                    }
                });
            }
        });
    }

    @Override
    public void getComment(String cid) {
        Request cidRequest = new Request.Builder().url(URLUtil.getDanmaku(cid)).build();
        BaseApplication.client.newCall(cidRequest).enqueue(new Callback() {

            private InputStream mStream;

            @Override
            public void onFailure(Call call, IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mPlayView.onGetCommentFail();
                    }
                });
                LogUtil.i(TAG, "获取弹幕文件失败");
            }

            @Override
            public void onResponse(Call call, Response response) {
                //数据经过Deflate压缩
                mStream = response.body().byteStream();
                mStream = new BufferedInputStream(mStream);//缓冲
                mStream = new InflaterInputStream(mStream, new Inflater(true));//解压,忽略zlib头
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mPlayView.onGetCommentSuccess(mStream);
                    }
                });
                LogUtil.i(TAG, "获取弹幕文件成功");
            }
        });
    }
}
