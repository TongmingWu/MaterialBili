package com.tongming.materialbili.base;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Tongming on 2016/3/19.
 */
public class BaseApplication extends Application {

    private String TAG = "APP";
    private static Context mInstance;
    private RefWatcher refWatcher;

    public static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();
    public static Gson gson = new GsonBuilder().create();

    public static RefWatcher getRefWatcher(Context context){
        BaseApplication application = (BaseApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = getApplicationContext();
        refWatcher = LeakCanary.install(this);
    }

    public static Context getInstance() {
        return mInstance;
    }

}
