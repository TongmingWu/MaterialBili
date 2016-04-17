package com.tongming.materialbili.base;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Tongming on 2016/3/19.
 */
public class BaseApplication extends Application {

    private String TAG = "APP";
    private static Context mInstance;
    private RefWatcher refWatcher;

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
