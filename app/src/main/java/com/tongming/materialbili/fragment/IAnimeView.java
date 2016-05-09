package com.tongming.materialbili.fragment;

import com.tongming.materialbili.model.Bangumi;
import com.tongming.materialbili.model.Banner;

/**
 * Created by Tongming on 2016/4/23.
 */
public interface IAnimeView {
    void onGetAnimeResult(Bangumi bangumi);
    void onGetBannerResult(Banner banner);
}
