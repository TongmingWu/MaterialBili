package com.tongming.materialbili.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.squareup.leakcanary.RefWatcher;
import com.tongming.materialbili.R;
import com.tongming.materialbili.adapter.PanDramaVideoGridAdapter;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.base.BaseFragment;
import com.tongming.materialbili.model.Bangumi;
import com.tongming.materialbili.model.IndexBanner;
import com.tongming.materialbili.network.DoRequest;
import com.tongming.materialbili.utils.LogUtil;
import com.tongming.materialbili.view.PanItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * 番剧页面
 * Created by Tongming on 2016/3/2.
 */
public class AnimeFragment extends BaseFragment {
    private final String TAG = "Anime";
    private boolean isPrepared;
    private ConvenientBanner convenientBanner;
    private View view;
    private SwipeRefreshLayout swipeRefreshLayout;

    private List<String> Images0 = new ArrayList<>();
    private List<String> count0 = new ArrayList<>();
    private List<String> title0 = new ArrayList<>();
    private List<String> date0 = new ArrayList<>();

    private List<String> Images1 = new ArrayList<>();
    private List<String> count1 = new ArrayList<>();
    private List<String> title1 = new ArrayList<>();
    private List<String> date1 = new ArrayList<>();

    private List<String> Images2 = new ArrayList<>();
    private List<String> count2 = new ArrayList<>();
    private List<String> title2 = new ArrayList<>();
    private List<String> date2 = new ArrayList<>();

    private List<String> Images3 = new ArrayList<>();
    private List<String> count3 = new ArrayList<>();
    private List<String> title3 = new ArrayList<>();
    private List<String> date3 = new ArrayList<>();

    private List<String> Images4 = new ArrayList<>();
    private List<String> count4 = new ArrayList<>();
    private List<String> title4 = new ArrayList<>();
    private List<String> date4 = new ArrayList<>();

    private List<String> Images5 = new ArrayList<>();
    private List<String> count5 = new ArrayList<>();
    private List<String> title5 = new ArrayList<>();
    private List<String> date5 = new ArrayList<>();

    private List<String> Images6 = new ArrayList<>();
    private List<String> count6 = new ArrayList<>();
    private List<String> title6 = new ArrayList<>();
    private List<String> date6 = new ArrayList<>();
    private GridView gv_sunday;
    private GridView gv_monday;
    private GridView gv_tuesday;
    private GridView gv_wednesday;
    private GridView gv_thursday;
    private GridView gv_friday;
    private GridView gv_saturday;

    private Bangumi bangumi;
    private IndexBanner indexBanner;
    private List<String> netImages = new ArrayList<>();
    private boolean flag = false;

    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    bangumi = (Bangumi) msg.obj;
                    initVideo();
                    break;
                case 1:
                    indexBanner = (IndexBanner) msg.obj;
                    initBanner();
                    swipeRefreshLayout.post(new Runnable() {
                        @Override
                        public void run() {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    });
                    mRoot.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    private LinearLayout mRoot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = super.onCreateView(inflater, container, savedInstanceState);
        //doRequest();
        LogUtil.i("Fragment", "Anime");
        initView();
        isPrepared = true;
        lazyLoad();
        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pandrama;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {

    }

    private void initVideo() {
        if (bangumi.getsundays() != null) {
            for (int i = 0; i < bangumi.getsundays().size(); i++) {
                Images0.add(bangumi.getsundays().get(i).getCover());
                count0.add(bangumi.getsundays().get(i).getBgmcount());
                title0.add(bangumi.getsundays().get(i).getTitle());
                date0.add(bangumi.getsundays().get(i).getLastupdate_at());
            }
        }
        if (bangumi.getmondays() != null) {
            for (int i = 0; i < bangumi.getmondays().size(); i++) {
                Images1.add(bangumi.getmondays().get(i).getCover());
                count1.add(bangumi.getmondays().get(i).getBgmcount());
                title1.add(bangumi.getmondays().get(i).getTitle());
                date1.add(bangumi.getmondays().get(i).getLastupdate_at());
            }
        }
        if (bangumi.gettuesdays() != null) {
            for (int i = 0; i < bangumi.gettuesdays().size(); i++) {
                Images2.add(bangumi.gettuesdays().get(i).getCover());
                count2.add(bangumi.gettuesdays().get(i).getBgmcount());
                title2.add(bangumi.gettuesdays().get(i).getTitle());
                date2.add(bangumi.gettuesdays().get(i).getLastupdate_at());
            }
        }
        if (bangumi.getwednesdays() != null) {
            for (int i = 0; i < bangumi.getwednesdays().size(); i++) {
                Images3.add(bangumi.getwednesdays().get(i).getCover());
                count3.add(bangumi.getwednesdays().get(i).getBgmcount());
                title3.add(bangumi.getwednesdays().get(i).getTitle());
                date3.add(bangumi.getwednesdays().get(i).getLastupdate_at());
            }
        }
        if (bangumi.getthursdays() != null) {
            for (int i = 0; i < bangumi.getthursdays().size(); i++) {
                Images4.add(bangumi.getthursdays().get(i).getCover());
                count4.add(bangumi.getthursdays().get(i).getBgmcount());
                title4.add(bangumi.getthursdays().get(i).getTitle());
                date4.add(bangumi.getthursdays().get(i).getLastupdate_at());
            }
        }
        if (bangumi.getfridays() != null) {
            for (int i = 0; i < bangumi.getmondays().size(); i++) {
                Images5.add(bangumi.getmondays().get(i).getCover());
                count5.add(bangumi.getmondays().get(i).getBgmcount());
                title5.add(bangumi.getmondays().get(i).getTitle());
                date5.add(bangumi.getmondays().get(i).getLastupdate_at());
            }
        }
        if (bangumi.getsaturdays() != null) {
            for (int i = 0; i < bangumi.getsaturdays().size(); i++) {
                Images6.add(bangumi.getsaturdays().get(i).getCover());
                count6.add(bangumi.getsaturdays().get(i).getBgmcount());
                title6.add(bangumi.getsaturdays().get(i).getTitle());
                date6.add(bangumi.getsaturdays().get(i).getLastupdate_at());
            }
        }
        gv_sunday.setAdapter(new PanDramaVideoGridAdapter(Images0, title0, date0, count0, activity));
        gv_monday.setAdapter(new PanDramaVideoGridAdapter(Images1, title1, date1, count1, activity));
        gv_tuesday.setAdapter(new PanDramaVideoGridAdapter(Images2, title2, date2, count2, activity));
        gv_wednesday.setAdapter(new PanDramaVideoGridAdapter(Images3, title3, date3, count3, activity));
        gv_thursday.setAdapter(new PanDramaVideoGridAdapter(Images4, title4, date4, count4, activity));
        gv_friday.setAdapter(new PanDramaVideoGridAdapter(Images5, title5, date5, count5, activity));
        gv_saturday.setAdapter(new PanDramaVideoGridAdapter(Images6, title6, date6, count6, activity));
    }

    private void initBanner() {
        if (netImages.size() > 0) {
            netImages.clear();
            for (int i = indexBanner.getBanners().size(); i >= 0; i--) {
                netImages.add(indexBanner.getBanners().get(i).getImg());
            }
        } else {
            //初始化banner数据
            for (int i = 0; i < indexBanner.getBanners().size(); i++) {
                netImages.add(indexBanner.getBanners().get(i).getImg());
            }
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

    private static class NetworkImageHolderView implements Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Glide.with(context).load(data).into(imageView);
        }
    }

    private void initView() {
        mRoot = (LinearLayout) view.findViewById(R.id.ll_pan_root);
        convenientBanner = (ConvenientBanner) view.findViewById(R.id.convenientBanner);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        initSwipeRefresh();
        PanItemView piv_sun = (PanItemView) view.findViewById(R.id.pan_sun);
        gv_sunday = piv_sun.getGvView();
        gv_sunday.setFocusable(false);
        PanItemView piv_mon = (PanItemView) view.findViewById(R.id.pan_mon);
        gv_monday = piv_mon.getGvView();
        gv_monday.setFocusable(false);
        PanItemView piv_tue = (PanItemView) view.findViewById(R.id.pan_tues);
        gv_tuesday = piv_tue.getGvView();
        gv_tuesday.setFocusable(false);
        PanItemView piv_wed = (PanItemView) view.findViewById(R.id.pan_wen);
        gv_wednesday = piv_wed.getGvView();
        gv_wednesday.setFocusable(false);
        PanItemView piv_thur = (PanItemView) view.findViewById(R.id.pan_thur);
        gv_thursday = piv_thur.getGvView();
        gv_thursday.setFocusable(false);
        PanItemView piv_fri = (PanItemView) view.findViewById(R.id.pan_fri);
        gv_friday = piv_fri.getGvView();
        gv_friday.setFocusable(false);
        PanItemView piv_sat = (PanItemView) view.findViewById(R.id.pan_sat);
        gv_saturday = piv_sat.getGvView();
        gv_saturday.setFocusable(false);

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
            DoRequest.getBangumi(handler);
            DoRequest.getBanner(handler);
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
}
