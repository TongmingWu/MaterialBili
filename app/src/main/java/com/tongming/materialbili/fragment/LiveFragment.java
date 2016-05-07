package com.tongming.materialbili.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.squareup.leakcanary.RefWatcher;
import com.tongming.materialbili.CusView.CusListView;
import com.tongming.materialbili.CusView.NetworkImageHolderView;
import com.tongming.materialbili.R;
import com.tongming.materialbili.adapter.GridInListAdapter;
import com.tongming.materialbili.adapter.IconGridAdapter;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.base.BaseFragment;
import com.tongming.materialbili.model.LiveVideo;
import com.tongming.materialbili.presenter.LivePresenterCompl;
import com.tongming.materialbili.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 直播页面
 * Created by Tongming on 2016/3/2.
 */
public class LiveFragment extends BaseFragment implements ILiveView {

    private final String TAG = "Live";
    private boolean isPrepared;
    //轮播图的图片id
    private List<String> imgs = new ArrayList<>();
    //轮播图下方的GridView中的item
    private final String[] mItems = {"绘画专区", "御宅文化", "生活娱乐",
            "单机联机", "网络游戏", "电子竞技", "放映厅", "全部直播"};
    //GridView中的图片资源id
    private final int[] imagesId2 = {R.drawable.live_9, R.drawable.live_2,
            R.drawable.live_6, R.drawable.live_1,
            R.drawable.live_3, R.drawable.live_4,
            R.drawable.live_7, R.drawable.ic_category_live_l8};
    private ConvenientBanner convenientBanner;
    private View view;
    private GridView gv_live;
    private SwipeRefreshLayout swipeRefreshLayout;

    private boolean flag = false;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    private CusListView lvLive;
    private Button moreLive;
    private LinearLayout mLlTop;
    private LivePresenterCompl mPresenterCompl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = super.onCreateView(inflater, container, savedInstanceState);
        LogUtil.i("Fragment", "Live");
        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {
        initView();
        isPrepared = true;
        lazyLoad();
        initSwipeRefresh();
    }

    private void initData(LiveVideo live) {

        if (live != null) {
            lvLive.setAdapter(new GridInListAdapter(getActivity(), live.getData().getPartitions()));
            lvLive.setExpanded(true);
        }
    }

    private void initView() {
        convenientBanner = (ConvenientBanner) view.findViewById(R.id.convenientBanner);

        imgs.add("http://i2.hdslb.com/u_user/77ff62edd818248945ee734557cbc2df.jpg");
        imgs.add("http://i2.hdslb.com/u_user/29749bd2f327952b890210c22ac2dc17.jpg");

        convenientBanner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new NetworkImageHolderView();
            }
        }, imgs)
                .setPageIndicator(new int[]{R.drawable.point_bg_normal, R.drawable.point_bg_enable})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        gv_live = (GridView) view.findViewById(R.id.gv_live);
        gv_live.setAdapter(new IconGridAdapter(mItems, imagesId2));

        lvLive = (CusListView) view.findViewById(R.id.lv_live);

        mLlTop = (LinearLayout) view.findViewById(R.id.ll_top);
        moreLive = (Button) view.findViewById(R.id.btn_more_live);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);

        mPresenterCompl = new LivePresenterCompl(this);
    }

    @Override
    public void onGetLiveResult(LiveVideo live) {
        initData(live);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        moreLive.setVisibility(View.VISIBLE);
        mLlTop.setVisibility(View.VISIBLE);
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
                        //通过setRefreshing(false)使动画停止
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
            mPresenterCompl.getVideo();
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
        //handler.removeCallbacksAndMessages(null);
        RefWatcher refWatcher = BaseApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
