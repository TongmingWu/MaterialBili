package com.tongming.materialbili.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.tongming.materialbili.CusView.CusListView;
import com.tongming.materialbili.R;
import com.tongming.materialbili.activity.VideoPlayActivity;
import com.tongming.materialbili.adapter.CommentAdapter;
import com.tongming.materialbili.base.BaseFragment;
import com.tongming.materialbili.model.Comment;
import com.tongming.materialbili.presenter.ReviewPresenterCompl;
import com.tongming.materialbili.utils.ToastUtil;

import java.util.List;

/**
 * Created by Tongming on 2016/3/20.
 */
public class ReviewFragment extends BaseFragment implements IReviewView {

    private View view;
    private String aid;
    private boolean isSend;

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    aid = (String) msg.obj;
                    mReviewPresenterCompl.getReview(aid);
                    break;
            }
        }
    };
    private Comment mComment;
    private List<Comment.ListEntity> list;
    private CommentAdapter adapter;
    private CusListView mHotComment;
    private CusListView mNormalComment;
    private ReviewPresenterCompl mReviewPresenterCompl;
    private EditText mEditMsg;
    private ImageButton mImageButton;
    private ProgressDialog mDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    private void initView(){
//        mHotComment = (CusListView) view.findViewById(R.id.lv_hot_comment);
        mNormalComment = (CusListView) view.findViewById(R.id.lv_normal_comment);
        mEditMsg = (EditText) view.findViewById(R.id.et_msg);
        mImageButton = (ImageButton) view.findViewById(R.id.btn_send);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = mEditMsg.getText().toString();
                mReviewPresenterCompl.sendReview(aid,msg);
                mDialog = new ProgressDialog(getActivity());
                mDialog.setMessage("发送评论中...");
                mDialog.show();
            }
        });
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
    public void onGetReviewResult(Comment comment) {
        mComment = comment;
//        mHotComment.setAdapter(new CommentAdapter(mComment.getHotList(),0));

        if(isSend){
            list.clear();
            list.addAll(mComment.getList());
            adapter.notifyDataSetChanged();
        }else {
            //评论成功后刷新数据
            list = mComment.getList();
            adapter = new CommentAdapter(list,1);
            mNormalComment.setAdapter(adapter);
        }

//        ListViewUtil.setListViewHeightBasedOnChildren(mHotComment);
    }

    @Override
    public void onSendReviewResult(int result) {
        mDialog.dismiss();
        if(result==1){
            ToastUtil.showToast(getActivity(),"评论成功");
            mEditMsg.setText("");
            isSend = true;
            mReviewPresenterCompl.getReview(aid);
        }else {
            ToastUtil.showToast(getActivity(),"评论失败");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            VideoPlayActivity mActivity = (VideoPlayActivity) context;
            mActivity.setReviewHandler(mHandler);
        }
    }
}
