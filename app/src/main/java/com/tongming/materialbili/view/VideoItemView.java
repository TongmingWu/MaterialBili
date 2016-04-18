package com.tongming.materialbili.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tongming.materialbili.R;

/**
 * Created by Tongming on 2016/4/12.
 */
public class VideoItemView extends LinearLayout {

    private ImageView ivView;
    private TextView tvDesc;
    private String mDesc;
    private int mImg;
    private GridView gvView;
    private TextView tvMore;
    private String more;

    public VideoItemView(Context context) {
        super(context);
    }

    public VideoItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //加载视图布局
        LayoutInflater.from(context).inflate(R.layout.view_video_item,this,true);

        //加载自定义的属性
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.VideoItemView);
        mDesc = array.getString(R.styleable.VideoItemView_view_desc);
        mImg = array.getResourceId(R.styleable.VideoItemView_view_src,0);
        more = array.getString(R.styleable.VideoItemView_view_more);

        //回收资源
        array.recycle();

    }

    public VideoItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VideoItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    //控件绘制完成
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        initView();
    }

    private void initView(){

        ivView = (ImageView) findViewById(R.id.iv_view);
        tvDesc = (TextView) findViewById(R.id.tv_view_desc);
        gvView = (GridView) findViewById(R.id.gv_view);
        tvMore = (TextView) findViewById(R.id.tv_view_more);

        if(!TextUtils.isEmpty(mDesc)){
            setTvDesc(mDesc);
        }
        if(!TextUtils.isEmpty(more)){
            setTvMore(more);
        }
        setIvView(mImg);
    }

    public GridView getGvView(){
        return gvView;
    }

    public void setTvDesc(String desc){
        tvDesc.setText(desc);
    }

    public void setIvView(int id){
        ivView.setImageResource(id);
    }

    public void setTvMore(String more){
        tvMore.setText(more);
    }
}
