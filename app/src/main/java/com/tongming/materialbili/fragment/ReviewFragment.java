package com.tongming.materialbili.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tongming.materialbili.R;
import com.tongming.materialbili.activity.VideoPlayActivity;
import com.tongming.materialbili.adapter.CommentAdapter;
import com.tongming.materialbili.base.BaseFragment;
import com.tongming.materialbili.model.Comment;
import com.tongming.materialbili.presenter.ReviewPresenterCompl;
import com.tongming.materialbili.utils.ListViewUtil;
import com.tongming.materialbili.CusView.CusListView;

/**
 * Created by Tongming on 2016/3/20.
 */
public class ReviewFragment extends BaseFragment implements IReviewView {

    private View view;

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    String aid = (String) msg.obj;
                    //DoRequest.getComment(aid,mHandler);
                    mReviewPresenterCompl.getReview(aid);
                    break;
                /*case 1:
                    mComment = (Comment) msg.obj;
                    initData();
                    break;*/
            }
        }
    };
    private Comment mComment;
    private CusListView mHotComment;
    private CusListView mNormalComment;
    private ReviewPresenterCompl mReviewPresenterCompl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    private void initData(Comment comment){
        mComment = comment;
        mHotComment.setAdapter(new CommentAdapter(mComment.getHotList(),0));
        mNormalComment.setAdapter(new CommentAdapter(mComment.getList(),1));
        ListViewUtil.setListViewHeightBasedOnChildren(mHotComment);
        ListViewUtil.setListViewHeightBasedOnChildren(mNormalComment);
    }

    private void initView(){
        mHotComment = (CusListView) view.findViewById(R.id.lv_hot_comment);
        mNormalComment = (CusListView) view.findViewById(R.id.lv_normal_comment);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.pager_review;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {
        initView();
        mReviewPresenterCompl = new ReviewPresenterCompl(this);
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            VideoPlayActivity mActivity = (VideoPlayActivity) context;
            mActivity.setReviewHandler(mHandler);
        }
    }

    @Override
    public void onGetReviewResult(Comment comment) {
        initData(comment);
    }
}
