package com.tongming.materialbili.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.squareup.leakcanary.RefWatcher;
import com.tongming.materialbili.R;
import com.tongming.materialbili.adapter.GridInListAdapter;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.base.BaseFragment;
import com.tongming.materialbili.model.Bangumi;
import com.tongming.materialbili.model.IndexBanner;
import com.tongming.materialbili.presenter.AnimePresenterCompl;
import com.tongming.materialbili.utils.LogUtil;
import com.tongming.materialbili.CusView.CusListView;
import com.tongming.materialbili.CusView.NetworkImageHolderView;

import java.util.ArrayList;
import java.util.List;

/**
 * 番剧页面
 * Created by Tongming on 2016/3/2.
 */
public class AnimeFragment extends BaseFragment implements IAnimeView {
    private final String TAG = "Anime";
    private boolean isPrepared;
    private ConvenientBanner convenientBanner;
    private View view;
    private SwipeRefreshLayout swipeRefreshLayout;

    private List<String> netImages = new ArrayList<>();
    private boolean flag = false;

    private Handler handler = new Handler(Looper.getMainLooper());

    private LinearLayout mRoot;
    private AnimePresenterCompl mAnimePresenterCompl;
    private CusListView mLv_pan;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pandrama;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {
        LogUtil.i("Fragment", "Anime");
        initView();
        isPrepared = true;
        lazyLoad();
    }

    private void initVideo(Bangumi bangumi) {
        if(bangumi!=null){
            mLv_pan.setAdapter(new GridInListAdapter(bangumi,getActivity()));
        }
    }

    private void initBanner(IndexBanner indexBanner) {
        //初始化banner数据
        for (int i = indexBanner.getBanners().size() - 1; i >= 0; i--) {
            netImages.add(indexBanner.getBanners().get(i).getImg());
        }
        convenientBanner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new NetworkImageHolderView();
            }
        }, netImages)
                .setPageIndicator(new int[]{R.drawable.point_bg_normal, R.drawable.point_bg_enable})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
    }

    private void initView() {
        mRoot = (LinearLayout) view.findViewById(R.id.ll_pan_root);
        convenientBanner = (ConvenientBanner) view.findViewById(R.id.convenientBanner);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        initSwipeRefresh();
        mLv_pan = (CusListView) view.findViewById(R.id.lv_pan);

        mAnimePresenterCompl = new AnimePresenterCompl(this);

    }

    private void initSwipeRefresh() {
        //设置控件的颜色
        swipeRefreshLayout.setColorSchemeResources(new int[]{R.color.holo_blue_bright,
                R.color.holo_green_light, R.color.holo_orange_light});
        //下拉刷新操作
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });

    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared && !isVisible) {
            return;
        }
        if (!flag) {
            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(true);
                }
            });
            mAnimePresenterCompl.getVideo();
            mAnimePresenterCompl.getBanner();
            flag = true;
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        convenientBanner.startTurning(5000);
    }

    @Override
    public void onPause() {
        super.onPause();
        //停止自动翻页
        convenientBanner.stopTurning();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
        RefWatcher refWatcher = BaseApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }

    @Override
    public void onGetAnimeResult(Bangumi bangumi) {
        initVideo(bangumi);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        mRoot.setVisibility(View.VISIBLE);
    }

    @Override
    public void onGetBannerResult(IndexBanner banner) {
        initBanner(banner);
    }
}
