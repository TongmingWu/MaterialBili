package com.tongming.materialbili.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.reflect.TypeToken;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.fragment.IReviewView;
import com.tongming.materialbili.model.Comment;
import com.tongming.materialbili.utils.LogUtil;
import com.tongming.materialbili.utils.URLUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/**
 * Created by Tongming on 2016/4/23.
 */
public class ReviewPresenterCompl implements IReviewPresenter {

    private static final String TAG = "Review";
    private IReviewView mReviewView;
    private Handler mHandler;

    public ReviewPresenterCompl(IReviewView reviewView) {
        mReviewView = reviewView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void getReview(final String aid) {
        new Thread(new Runnable() {
            BufferedReader bin;

            @Override
            public void run() {
                try {
                    URL url = new URL(URLUtil.getReview(aid));
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestProperty("Accept-Encoding", "gzip,deflate");
                    conn.connect();
                    LogUtil.i(TAG, conn.getContentEncoding() + "");
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
                            mReviewView.onGetReviewResult(comment);
                        }
                    });
                    LogUtil.i(TAG, "获取评论信息成功");
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
}
