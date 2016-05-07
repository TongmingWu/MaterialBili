package com.tongming.materialbili.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tongming.materialbili.CusView.CusListView;
import com.tongming.materialbili.R;
import com.tongming.materialbili.adapter.CommentAdapter;
import com.tongming.materialbili.model.Comment;
import com.tongming.materialbili.model.Contract;
import com.tongming.materialbili.model.PanDetail;
import com.tongming.materialbili.presenter.PanPresenterCompl;
import com.tongming.materialbili.utils.LogUtil;

/**
 * Created by Tongming on 2016/5/6.
 */
public class BangumiActivity extends AppCompatActivity implements IPanView {

    private static final String TAG = "Bangumi";
    private ImageView mIvPan;
    private TextView mPanName;
    private TextView mFinish;
    private TextView mUpdate;
    private TextView mPlayNum;
    private TextView mFans;
    private TextView mContract;
    private TextView mDesc;
    private LinearLayout mTag;
    private CusListView mComment;
    private PanPresenterCompl mPresenterCompl;
    private LinearLayout mPanSelect;
    private LinearLayout.LayoutParams mTextParams;
    private LinearLayout.LayoutParams linearParams;
    private TextView mTvComment;
    private PanDetail detail1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangumi_detail);
        Intent intent = getIntent();
        String season = intent.getStringExtra("seasonID");
        mPresenterCompl = new PanPresenterCompl(this);
        mPresenterCompl.getPanDetail(season);
        initView();
    }

    private void initView() {
        mIvPan = (ImageView) findViewById(R.id.iv_cover);
        mPanName = (TextView) findViewById(R.id.tv_pan_name);
        mFinish = (TextView) findViewById(R.id.tv_pan_isFinish);
        mUpdate = (TextView) findViewById(R.id.tv_pan_update);
        mPlayNum = (TextView) findViewById(R.id.tv_pan_playNum);
        mFans = (TextView) findViewById(R.id.tv_pan_fans);
        mPanSelect = (LinearLayout) findViewById(R.id.ll_pan_select);
        mContract = (TextView) findViewById(R.id.tv_contract_num);
        mDesc = (TextView) findViewById(R.id.tv_pan_desc);
        mTag = (LinearLayout) findViewById(R.id.rl_pan_tag);
        mTvComment = (TextView) findViewById(R.id.tv_pan_comment);
        mComment = (CusListView) findViewById(R.id.lv_pan_comment);
    }


    @Override
    public void onGetPanDetail(PanDetail detail) {
        this.detail1 = detail;
        Glide.with(this).load(detail.getImg()).into(mIvPan);
        mPanName.setText(detail.getName());
        if (detail.isFinish()) {
            mFinish.setText("已完结");
        } else {
            mFinish.setText("连载中");
        }
        mUpdate.setText(detail.getUpdate_date());
        mPlayNum.setText("播放: " + detail.getPlay_count());
        mFans.setText("追番: " + detail.getFans_num());

        //选集
        mTextParams = new LinearLayout.LayoutParams(160, 60);
        mTextParams.setMargins(5, 5, 5, 5);
        mTextParams.weight = 1;
        linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int count = detail.getPan_count();
        int row = count / 4;
        int leftCount = count - 4 * row;
        if (leftCount == 0) {
            for (int i = 0; i < row; i++) {
                inflateTextView(count - i * 4, 0);
            }
        } else {
            for (int i = 0; i < row + 1; i++) {
                if (i == row) {
                    inflateTextView(leftCount, 1);
                } else {
                    inflateTextView(count - i * 4, 0);
                }
            }
        }

        mDesc.setText(detail.getDesc());
        String[] tag = detail.getStyle().split(" ");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 45);
        params.setMarginStart(20);
        for (int i = 0; i < tag.length; i++) {
            TextView tvTag = new TextView(this);
            tvTag.setText(tag[i]);
            tvTag.setGravity(Gravity.CENTER);
            tvTag.setBackgroundResource(R.drawable.rectangle_data);
            mTag.addView(tvTag, params);
        }
        mPresenterCompl.getContract(detail.getResults().get(detail.getResults().size() - 1).getAid());
        mPresenterCompl.getPanComment(detail.getResults().get(detail.getResults().size() - 1).getAid());
    }

    private void inflateTextView(final int c, int type) {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        mPanSelect.addView(layout, linearParams);
        if (type == 0) {
            for (int i = c; i > c - 4; i--) {
                TextView textView = new TextView(this);
                textView.setBackgroundResource(R.drawable.rectangle_data);
                textView.setText(i + "");
                textView.setGravity(Gravity.CENTER);
                layout.addView(textView, mTextParams);
                final int j = i;
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LogUtil.i(TAG,(j-1)+"");
                        Intent intent = new Intent(BangumiActivity.this,VideoPlayActivity.class);
                        intent.putExtra("aid",detail1.getResults().get(j-1).getAid());
                        startActivity(intent);
                    }
                });
            }
        } else {
            for (int i = c; i > 0; i--) {
                TextView textView = new TextView(this);
                textView.setBackgroundResource(R.drawable.rectangle_data);
                textView.setText(i + "");
                textView.setGravity(Gravity.CENTER);
                final int j = i;
                layout.addView(textView, mTextParams);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(BangumiActivity.this,VideoPlayActivity.class);
                        LogUtil.i(TAG,(j-1)+"");
                        intent.putExtra("aid",detail1.getResults().get(j-1).getAid());
                        startActivity(intent);
                    }
                });
            }
        }
    }

    @Override
    public void onGetPanComment(Comment comment) {
        mTvComment.setText("第1话评论("+comment.getResults()+")");
        mComment.setAdapter(new CommentAdapter(comment.getHotList(),0));
        mComment.setExpanded(true);
    }

    @Override
    public void onGetPanContract(Contract contract) {
        mContract.setText(contract.getUsers() + "人承包了第1话");
    }
}
