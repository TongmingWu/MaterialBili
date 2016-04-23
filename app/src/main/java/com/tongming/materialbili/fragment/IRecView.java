package com.tongming.materialbili.fragment;

import com.tongming.materialbili.model.HotVideo;
import com.tongming.materialbili.model.IndexBanner;

/**
 * Created by Tongming on 2016/4/23.
 */
public interface IRecView {
    void onGetVideoResult(HotVideo hotVideo);
    void onGetBannerResult(IndexBanner banner);
}
