package com.tongming.materialbili.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Tongming on 2016/3/20.
 */
public abstract class BaseFragment extends Fragment {
    protected Activity activity;
    protected View mRootView;
    protected boolean isVisible = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mRootView==null){
            mRootView = inflater.inflate(getLayoutId(),null);
        }
        return mRootView;//这里返回的视图
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        afterCreate(savedInstanceState);
    }

    protected abstract int getLayoutId();

    protected abstract void afterCreate(Bundle saveInstanceState);


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = getActivity();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()&&!isVisible){
            onVisible();
            isVisible = true;
        }else {
            isVisible = false;
            onInvisible();
        }
    }

    private void onVisible(){
        lazyLoad();
    }
    protected abstract void lazyLoad();
    private void onInvisible(){}
}
