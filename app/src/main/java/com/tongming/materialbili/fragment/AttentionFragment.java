package com.tongming.materialbili.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tongming.materialbili.R;
import com.tongming.materialbili.base.BaseFragment;
import com.tongming.materialbili.utils.LogUtil;
import com.tongming.materialbili.utils.TranslucentUtil;

/**
 * 关注页面
 * Created by Tongming on 2016/3/2.
 */
public class AttentionFragment extends BaseFragment {

    private View view;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = super.onCreateView(inflater, container, savedInstanceState);
        TranslucentUtil.translucentNavigation(getActivity());
        initView();
        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_attention;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {

    }

    @Override
    protected void lazyLoad() {

    }

    private void initView(){
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        initSwipeRefresh();
    }
    private void initSwipeRefresh(){
        //设置控件的颜色
        swipeRefreshLayout.setColorSchemeResources(new int[]{R.color.holo_blue_bright,
                R.color.holo_green_light,R.color.holo_orange_light});
        //下拉刷新操作
        /*swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                HomeActivity.handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //通过setRefreshing(false)使动画停止
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },3000);
            }
        });*/
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.i("Fragment","Attention");
    }
}
