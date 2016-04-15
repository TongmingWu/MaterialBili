package com.tongming.materialbili.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tongming.materialbili.R;
import com.tongming.materialbili.base.BaseFragment;
import com.tongming.materialbili.utils.LogUtil;

/**
 * 发现页面
 * Created by Tongming on 2016/3/2.
 */
public class DiscoverFragment extends BaseFragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = super.onCreateView(inflater, container, savedInstanceState);
        //TranslucentUtil.translucentNavigation(getActivity());
        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {

    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.i("Fragment", "Discover");
    }
}
