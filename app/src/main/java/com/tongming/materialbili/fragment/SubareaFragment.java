package com.tongming.materialbili.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.tongming.materialbili.R;
import com.tongming.materialbili.adapter.IconGridAdapter;
import com.tongming.materialbili.base.BaseFragment;
import com.tongming.materialbili.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 分区页面
 * Created by Tongming on 2016/3/2.
 */
public class SubareaFragment extends BaseFragment {
    //图片资源id
    private static final String[] mItems = {
            "直播","番剧","动画","音乐","舞蹈","游戏","科技","娱乐","鬼畜","电影","电视剧","科技","游戏中心"
    };
    private static final int[] imagesId = {R.drawable.ic_category_t1,R.drawable.ic_category_t2,R.drawable.ic_category_t3,
    R.drawable.ic_category_t4,R.drawable.ic_category_t5,R.drawable.ic_category_t6,R.drawable.ic_category_t7,
    R.drawable.ic_category_t8,R.drawable.ic_category_t9,R.drawable.ic_category_t10,
    R.drawable.ic_category_t11,R.drawable.ic_category_t12,R.drawable.ic_category_t13};
    private GridView gv_sub;
    private List<ImageView> imageViews = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        gv_sub = (GridView) view.findViewById(R.id.gv_sub);
        initData();
        gv_sub.setAdapter(new IconGridAdapter(mItems,imagesId,getActivity()));
        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_subarea;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {

    }

    @Override
    protected void lazyLoad() {

    }

    //初始化数据
    private void initData(){

    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.i("Fragment","Sub");
    }
}
