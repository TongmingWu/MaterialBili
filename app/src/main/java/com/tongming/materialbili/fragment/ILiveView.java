package com.tongming.materialbili.fragment;

import com.tongming.materialbili.model.LiveVideo;

import org.json.JSONObject;

/**
 * Created by Tongming on 2016/4/23.
 */
public interface ILiveView {
    void onGetLiveResult(LiveVideo live);
    void onGetComment(JSONObject object);
}
