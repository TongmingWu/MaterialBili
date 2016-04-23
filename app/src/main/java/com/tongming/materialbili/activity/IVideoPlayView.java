package com.tongming.materialbili.activity;

import com.tongming.materialbili.model.AidVideo;
import com.tongming.materialbili.model.VideoUrl;

import java.io.InputStream;

/**
 * Created by Tongming on 2016/4/23.
 */
public interface IVideoPlayView {
    void onGetVideoInfo(AidVideo video);
    void onGetUrl(VideoUrl url);
    void onGetCommentFail();
    void onGetCommentSuccess(InputStream stream);
}
