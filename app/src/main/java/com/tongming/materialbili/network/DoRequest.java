package com.tongming.materialbili.network;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tongming.materialbili.model.AidVideo;
import com.tongming.materialbili.model.Bangumi;
import com.tongming.materialbili.model.HashKey;
import com.tongming.materialbili.model.HotVideo;
import com.tongming.materialbili.model.IndexBanner;
import com.tongming.materialbili.model.LiveVideo;
import com.tongming.materialbili.model.User;
import com.tongming.materialbili.model.VideoUrl;
import com.tongming.materialbili.utils.LogUtil;
import com.tongming.materialbili.utils.URLUtil;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Tongming on 2016/4/13.
 */
public class DoRequest {

    private static final String TAG = "Request";
    private static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();
    private static Gson gson = new GsonBuilder().create();


    //获取用户信息
    public static void getUserInfo(final Handler handler) {
        final Request requestVideo = new Request.Builder().url(URLUtil.USER).build();
        client.newCall(requestVideo).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.e(TAG, "获取用户数据失败");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                User user = gson.fromJson(response.body().string(), new TypeToken<User>() {
                }.getType());
                Message msg = handler.obtainMessage();
                msg.what = 0;
                msg.obj = user;
                handler.sendMessage(msg);
                LogUtil.i(TAG, "获取用户数据成功");
            }
        });
    }

    //获取视频分类的信息
    public static void getHotVideo(final Handler handler) {
        final Request requestVideo = new Request.Builder().url(URLUtil.HOT_VIEDO).build();
        client.newCall(requestVideo).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.e(TAG, "获取hot失败数据失败");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                HotVideo hotVideo = gson.fromJson(response.body().string(), new TypeToken<HotVideo>() {
                }.getType());
                Message msg = handler.obtainMessage();
                msg.what = 0;
                msg.obj = hotVideo;
                handler.sendMessage(msg);
                LogUtil.i(TAG, "获取数据成功");
            }
        });
    }

    //获取首页banner的json
    public static void getBanner(final Handler handler) {
        Request requestBanner = new Request.Builder().url(URLUtil.INDEXINFO).build();
        client.newCall(requestBanner).enqueue(new Callback() {
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
                IndexBanner indexBanner = gson.fromJson(jsonBanner,
                        new TypeToken<IndexBanner>() {
                        }.getType());
                Message msg = handler.obtainMessage();
                msg.what = 1;
                msg.obj = indexBanner;
                handler.sendMessage(msg);
                LogUtil.i(TAG, "获取banner数据成功");
            }
        });
    }

    //获取直播视频信息
    public static void getLive(final Handler handler) {
        Request requestLive = new Request.Builder().url(URLUtil.LIVEINFO).build();
        client.newCall(requestLive).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "获取直播信息失败");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                LiveVideo live = gson.fromJson(json,
                        new TypeToken<LiveVideo>() {
                        }.getType());
                Message msg = handler.obtainMessage();
                msg.what = 0;
                msg.obj = live;
                handler.sendMessage(msg);
                LogUtil.i(TAG, "获取直播数据成功");
            }
        });
    }

    //获取直播视频url
    public static void getLiveUrl(String room, final Handler handler) {

        Request request = new Request.Builder().url(URLUtil.LIVEVIDEO + room).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.e(TAG, "获取url失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                String url = data.substring(
                        data.indexOf("http://"),
                        data.indexOf("]", data.indexOf("http://")));
                LogUtil.i(TAG, url);
                Message msg = handler.obtainMessage();
                msg.what = 0;
                msg.obj = url;
                handler.sendMessage(msg);
            }
        });
    }

    //获取番剧信息
    public static void getBangumi(final Handler handler) {

        Request requestBangumi = new Request.Builder().url(URLUtil.BANGUMI).build();
        client.newCall(requestBangumi).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "获取番剧信息失败");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Bangumi bangumi = gson.fromJson(json,
                        new TypeToken<Bangumi>() {
                        }.getType());
                Message msg = handler.obtainMessage();
                msg.what = 0;
                msg.obj = bangumi;
                handler.sendMessage(msg);
                LogUtil.i(TAG, "获取番剧数据成功");
            }
        });
    }

    //获取视频cid
    public static void getCid(String aid, final Handler handler) {
        Request requestVideo = new Request.Builder().url(URLUtil.INFO_VIEDO + aid).build();
        client.newCall(requestVideo).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i("URL", "获取cid失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                AidVideo video = gson.fromJson(json, new TypeToken<AidVideo>() {
                }.getType());
                String cid = video.getList().getZero().getCid() + "";
                Message msg = handler.obtainMessage();
                msg.what = 0;
                Bundle bundle = new Bundle();
                bundle.putParcelable("video", video);
                bundle.putString("cid", cid);
                msg.setData(bundle);
                handler.sendMessage(msg);
                LogUtil.i("URL", "cid" + cid);
            }
        });
    }

    //获取视频下载地址
    public static void getUrl(String cid, final Handler handler) {
        Request requestUrl = new Request.Builder().url(URLUtil.VIDEODOWNLOAD + cid).build();
        client.newCall(requestUrl).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i("URL", "获取视频下载地址失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                VideoUrl url = gson.fromJson(json, new TypeToken<VideoUrl>() {
                }.getType());
                Message msg = handler.obtainMessage();
                msg.what = 1;
                msg.obj = url;
                handler.sendMessage(msg);
            }
        });
    }

    //搜索功能
    public static void doSearch(Map<String, String> map, final Handler handler) {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        RequestBody formBody = builder.build();
        Request request = new Request.Builder()
                .url(URLUtil.SEARCH_URL)
                .post(formBody)
                .build();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i("Search", "搜索失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Message msg = new Message();
                msg.what = 0;
                msg.obj = result;
                handler.sendMessage(msg);
                LogUtil.i("Search", "搜索成功");
            }
        });
    }

    //获取弹幕文件
    public static void getDanmaku(String danmaku, final Handler handler) {
        Request cidRequest = new Request.Builder().url(danmaku).build();
        client.newCall(cidRequest).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                Message msg = handler.obtainMessage();
                msg.what = 1;
                handler.sendMessage(msg);
                //ToastUtil.showToast(VideoPlayActivity.this,"获取弹幕失败- -");
                LogUtil.i(TAG, "获取弹幕文件失败");
            }

            @Override
            public void onResponse(Call call, Response response) {
                //数据经过Deflate压缩
                InputStream stream = response.body().byteStream();
                stream = new BufferedInputStream(stream);//缓冲
                stream = new InflaterInputStream(stream, new Inflater(true));//解压,忽略zlib头
                Message msg = handler.obtainMessage();
                msg.what = 0;
                msg.obj = stream;
                handler.sendMessage(msg);
                LogUtil.i(TAG, "获取弹幕文件成功");
            }
        });
    }

    //获取hash值
    public static void getHash(final Handler handler) {
        Request request = new Request.Builder().url(URLUtil.KEY).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                HashKey hashKey = gson.fromJson(response.body().string(),new TypeToken<HashKey>(){}.getType());
                Message msg = handler.obtainMessage();
                msg.what = 1;
                msg.obj = hashKey;
                handler.sendMessage(msg);
                LogUtil.i(TAG,"获取key成功");
            }
        });
    }
}
