package com.tongming.materialbili.utils;

import com.tongming.materialbili.model.HashKey;

import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 模拟登录B站
 * Created by Tongming on 2016/3/17.
 */
public class JsoupLoginBilibili {

//    private static Connection connection;

    //模拟登录
    /*public static void login(final String userid, final String pwd, final String vdcode) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Connection connection1 = Jsoup.connect("https://passport.bilibili.com/login/");
                    connection1
                            .userAgent("bilianime/570 CFNetwork/672.0.8 Darwin/14.0.0")
                            .referrer("https://passport.bilibili.com/login")
                            .header("Host", "passport.bilibili.com");

                    Connection.Response doLogin = connection1.ignoreHttpErrors(true).method(Connection.Method.GET)
                            .execute();
                    LogUtil.i("Login", doLogin.headers().toString());

                    String hash = BaseApplication.getKey().getHash();
                    PublicKey publicKey = RSA.loadPublicKey(BaseApplication.PUBLIC_KEY);
                    byte[] encryptByte = RSA.encryptData((hash + pwd).getBytes(), publicKey);
                    String pwd = Base64Utils.encode(encryptByte);
                    Connection connection = Jsoup.connect(URLUtil.LOGIN_URL);
                    connection
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36")
                            .referrer("https://passport.bilibili.com/login");
                    Connection.Response login = connection
                            .ignoreContentType(true)
                            .data("act", "login")
                            .data("gourl", "http://www.bilibili.com/")
                            .data("keeptime", "604800")
                            .data("userid", userid)//帐号
                            .data("pwd", pwd)        //密码
                            .data("vdcode", vdcode)  //验证码
                            .data("keeptime", "604800")
                            .cookies(doLogin.cookies())
                            .method(Connection.Method.POST)
                            .execute();

                    //带着cookies访问需要的网址
                    Document document = Jsoup.connect("http://www.bilibili.com")
                            .cookies(login.cookies()).get();*//**//**//**//**//**//**//*
                    LogUtil.i("Login", login.statusCode() + "");
                    LogUtil.i("Login", login.body());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }*/
    public static void okLogin(HashKey key ,String userid, String pwd, String vdcode) {
        OkHttpClient client = new OkHttpClient.Builder().cookieJar(new CookieJar() {
            private final HashMap<String, List<Cookie>> cookieStore = new HashMap<String, List<Cookie>>();

            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                cookieStore.put(url.host(), cookies);
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                List<Cookie> cookies = cookieStore.get(url.host());
                return cookies != null ? cookies : new ArrayList<Cookie>();
            }
        }).build();
        //String hash = BaseApplication.getKey().getHash();
        try {
            PublicKey publicKey = RSA.loadPublicKey(key.getKey());
            byte[] encryptByte = RSA.encryptData((key.getHash() + pwd).getBytes(), publicKey);
            pwd = Base64Utils.encode(encryptByte);
            LogUtil.i("Login", pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        FormBody formbody = new FormBody.Builder()
                .add("act", "login")
                .add("gourl", "http://www.bilibili.com/")
                .add("keeptime", "604800")
                .add("userid", userid)
                .add("pwd", pwd)
                .add("vdcode", vdcode)
                .add("keeptime", "604800")
                .build();
        Request request = new Request.Builder().url(URLUtil.LOGIN_URL)
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36")
                .addHeader("Referer","https://passport.bilibili.com/login")
                .post(formbody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtil.i("Login", response.body().string());
            }
        });
    }
}
