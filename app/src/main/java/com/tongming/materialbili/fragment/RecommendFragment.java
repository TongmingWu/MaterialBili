package com.tongming.materialbili.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.tongming.materialbili.R;
import com.tongming.materialbili.activity.VideoPlayActivity;
import com.tongming.materialbili.adapter.GridInListAdapter;
import com.tongming.materialbili.adapter.PanDramaVideoGridAdapter;
import com.tongming.materialbili.adapter.VideoGridAdapter;
import com.tongming.materialbili.base.BaseFragment;
import com.tongming.materialbili.model.HotVideo;
import com.tongming.materialbili.model.IndexBanner;
import com.tongming.materialbili.presenter.RecPresenterCompl;
import com.tongming.materialbili.utils.LogUtil;
import com.tongming.materialbili.CusView.NetworkImageHolderView;
import com.tongming.materialbili.CusView.PanItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐页面
 * Created by Tongming on 2016/3/2.
 */
public class RecommendFragment extends BaseFragment implements IRecView {

    private final String TAG = "Rec";
    //标志位,标志已经初始化完成
    private boolean isPrepared;

    private View view;
    private ConvenientBanner convenientBanner;
    private SwipeRefreshLayout swipeRefreshLayout;

    private boolean flag = false;//数据获取完成的标识

    private List<String> netImages = new ArrayList<>();

    private Handler mHandler = new Handler(Looper.getMainLooper());

    private ListView lvRec;
    private GridView gvPan;
    private GridView gvHot;
    private LinearLayout mTop;
    private RecPresenterCompl mPresenterCompl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = super.onCreateView(inflater, container, savedInstanceState);
        LogUtil.i("Fragment", "Recommend");
        return view;
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

        mPresenterCompl = new RecPresenterCompl(this);
    }

    //初始化数据
    private void initVideo(final HotVideo hotVideo) {
        gvHot.setAdapter(new VideoGridAdapter(hotVideo.getmovies(), 7));
        gvHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), VideoPlayActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("aid", hotVideo.getmovies().get(position).getAid());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        gvPan.setAdapter(new PanDramaVideoGridAdapter(hotVideo.getpanDramas()));
        gvPan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), VideoPlayActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("aid", hotVideo.getpanDramas().get(position).getAid());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        lvRec.setAdapter(new GridInListAdapter(getActivity(), hotVideo));
    }

    private void initBanner(IndexBanner indexBanner) {
        //初始化banner数据
        for (int i = 0; i < indexBanner.getBanners().size(); i++) {
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


    private void initSwipeRefresh() {
        //设置控件的颜色
        swipeRefreshLayout.setColorSchemeResources(new int[]{R.color.holo_blue_bright,
                R.color.holo_green_light, R.color.holo_orange_light});
        //下拉刷新操作
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
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
            mPresenterCompl.getVideo();
            mPresenterCompl.getBanner();
            flag = true;
        }
    }

    @Override
    public void onGetVideoResult(HotVideo hotVideo) {
        initVideo(hotVideo);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        mTop.setVisibility(View.VISIBLE);
    }

    @Override
    public void onGetBannerResult(IndexBanner banner) {
        initBanner(banner);
    }
}

