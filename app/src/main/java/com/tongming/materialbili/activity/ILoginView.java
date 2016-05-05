package com.tongming.materialbili.activity;

/**
 * Created by Tongming on 2016/4/27.
 */
public interface ILoginView {
    void onSuccess(String uid);
    void onFailed(int code);
}
