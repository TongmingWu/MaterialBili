package com.tongming.materialbili.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tongming.materialbili.activity.IPanView;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.model.Comment;
import com.tongming.materialbili.model.Contract;
import com.tongming.materialbili.model.PanDetail;
import com.tongming.materialbili.utils.URLUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tongming on 2016/5/7.
 */
public class PanPresenterCompl implements IPanPresenter {

    private static final String TAG = "Pan";
    private IPanView mPanView;
    private Handler mHandler;
    private OkHttpClient client = BaseApplication.client;
    private Gson mGson = BaseApplication.gson;

    public PanPresenterCompl(IPanView panView) {
        mPanView = panView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void getPanDetail(String season) {
        FormBody formBody = new FormBody.Builder().add("season_id", season).build();
        Request request = new Request.Builder().url(URLUtil.PYTHON_PAN).method("POST", formBody).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final PanDetail detail = mGson.fromJson(response.body().string(), new TypeToken<PanDetail>() {
                }.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mPanView.onGetPanDetail(detail);
                    }
                });
            }
        });
    }

    @Override
    public void getPanComment(final String aid) {
        new Thread(new Runnable() {
            BufferedReader bin;

            @Override
            public void run() {
                try {
                    URL url = new URL(URLUtil.getReview(aid));
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestProperty("Accept-Encoding", "gzip,deflate");
                    conn.connect();
                    InputStream in = conn.getInputStream();

                    GZIPInputStream gzin = new GZIPInputStream(in);

                    bin = new BufferedReader(new InputStreamReader(gzin, "UTF-8"));
                    String s = null;
                    StringBuilder sb = new StringBuilder();
                    while ((s = bin.readLine()) != null) {
                        sb.append(s);
                    }
                    final Comment comment = BaseApplication.gson.fromJson(
                            sb.toString(),
                            new TypeToken<Comment>() {
                            }.getType()
                    );
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mPanView.onGetPanComment(comment);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        bin.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void getContract(String aid) {
        Request request = new Request.Builder().url(URLUtil.CONTRACT + aid).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final Contract contract = mGson.fromJson(response.body().string(), new TypeToken<Contract>() {
                }.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mPanView.onGetPanContract(contract);
                    }
                });
            }
        });
    }
}
