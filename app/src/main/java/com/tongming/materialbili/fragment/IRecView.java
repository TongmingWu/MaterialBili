package com.tongming.materialbili.fragment;

import com.tongming.materialbili.model.Banner;
import com.tongming.materialbili.model.HotVideo;

/**
 * Created by Tongming on 2016/4/23.
 */
public interface IRecView {
    void onGetVideoResult(HotVideo hotVideo);
    void onGetBannerResult(Banner banner);
}
