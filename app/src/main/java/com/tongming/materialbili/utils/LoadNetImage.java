package com.tongming.materialbili.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 获取网络图片
 * Created by Tongming on 2016/3/22.
 */
public class LoadNetImage {

    public static void getVd(final String url, final Handler handler) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = getUrlImage(url);
                Message msg = new Message();
                msg.what = 0;
                msg.obj = bitmap;
                handler.sendMessage(msg);
            }
        }).start();

    }

    private static Bitmap getUrlImage(String url) {
        Bitmap bitmap = null;
        try {
            URL vdUrl = new URL(url);
            //获得连接
            HttpURLConnection conn = (HttpURLConnection) vdUrl.openConnection();
            conn.setConnectTimeout(5000);
            conn.setDoInput(true);
            conn.setUseCaches(false);//不缓存
            conn.connect();
            InputStream is = conn.getInputStream();//获取图片的数据流
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
