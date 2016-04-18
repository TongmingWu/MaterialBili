package com.tongming.materialbili.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.squareup.leakcanary.RefWatcher;
import com.tongming.materialbili.R;
import com.tongming.materialbili.activity.VideoPlayActivity;
import com.tongming.materialbili.adapter.GridInListAdapter;
import com.tongming.materialbili.adapter.PanDramaVideoGridAdapter;
import com.tongming.materialbili.adapter.VideoGridAdapter;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.base.BaseFragment;
import com.tongming.materialbili.model.HotVideo;
import com.tongming.materialbili.model.IndexBanner;
import com.tongming.materialbili.network.DoRequest;
import com.tongming.materialbili.utils.LogUtil;
import com.tongming.materialbili.view.PanItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐页面
 * Created by Tongming on 2016/3/2.
 */
public class RecommendFragment extends BaseFragment {

    private final String TAG = "Rec";
    //标志位,标志已经初始化完成
    private boolean isPrepared;
    //网络视频集合

    private List<String> panImages = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private List<String> date = new ArrayList<>();
    private List<String> panAid = new ArrayList<>();

    private View view;
    private ConvenientBanner convenientBanner;
    private SwipeRefreshLayout swipeRefreshLayout;

    private HotVideo hotVideo;
    private IndexBanner indexBanner;
    private boolean flag = false;//数据获取完成的标识

    private List<String> netImages = new ArrayList<>();


    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    //填充视频数据
                    hotVideo = (HotVideo) msg.obj;
                    initVideo();
                    swipeRefreshLayout.post(new Runnable() {
                        @Override
                        public void run() {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    });
                    mTop.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    //填充banner
                    indexBanner = (IndexBanner) msg.obj;
                    initBanner();
                    break;
            }
        }
    };
    private ListView lvRec;
    private GridView gvPan;
    private GridView gvHot;
    private LinearLayout mTop;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = super.onCreateView(inflater, container, savedInstanceState);
        //doRequest();
        LogUtil.i("Fragment", "Recommend");
        //初始化view的各控件
        /*initView();
        isPrepared = true;//初始化控件完成
        lazyLoad();*/
        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    //在Activity创建完成之后调用
    @Override
    protected void afterCreate(Bundle saveInstanceState) {
        initView();
        isPrepared = true;//初始化控件完成
        lazyLoad();
    }

    private void initView() {
        convenientBanner = (ConvenientBanner) view.findViewById(R.id.convenientBanner);
        //new ConvenientBannerUtil(localImages, imagesId, convenientBanner);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        //初始化下拉刷新控件
        initSwipeRefresh();

        mTop = (LinearLayout) view.findViewById(R.id.ll_top_rec);
        gvHot = (GridView) view.findViewById(R.id.gv_hot);
        PanItemView pivPan = (PanItemView) view.findViewById(R.id.rec_pan);
        gvPan = pivPan.getGvView();
        lvRec = (ListView) view.findViewById(R.id.lv_rec);
    }

    //初始化数据
    private void initVideo() {
            for (int i = 0; i < 4; i++) {
                panImages.add(hotVideo.getpanDramas().get(i).getPic());
                titles.add(hotVideo.getpanDramas().get(i).getTitle());
                date.add(hotVideo.getpanDramas().get(i).getCreate());
                panAid.add(hotVideo.getpanDramas().get(i).getAid());
            }
        gvHot.setAdapter(new VideoGridAdapter(hotVideo.gettvs(),7));
        gvHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), VideoPlayActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("aid",hotVideo.gettvs().get(position).getAid());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        gvPan.setAdapter(new PanDramaVideoGridAdapter(panImages,titles,date));
        gvPan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), VideoPlayActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("aid",panAid.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        lvRec.setAdapter(new GridInListAdapter(getActivity(),hotVideo));
    }

    private void initBanner() {
        //初始化banner数据
        if (netImages.size() > 0) {
            netImages.clear();
            for (int i = 0; i < indexBanner.getBanners().size(); i++) {
                netImages.add(indexBanner.getBanners().get(i).getImg());
            }
        } else {
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
            Glide.with(BaseApplication.getInstance()).load(data).into(imageView);
        }
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
                        //通过setRefreshing(false)使动画停止
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });

    }

    //当前Fragment显示在屏幕上才加载数据
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
            DoRequest.getHotVideo(handler);
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

