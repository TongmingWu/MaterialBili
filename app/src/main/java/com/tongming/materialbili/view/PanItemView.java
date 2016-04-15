package com.tongming.materialbili.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tongming.materialbili.R;

/**
 * Created by Tongming on 2016/4/12.
 */
public class PanItemView extends RelativeLayout {

    private ImageView ivView;
    private TextView tvDesc;
    private String mDesc;
    private int mImg;
    private GridView gvView;

    public PanItemView(Context context) {
        super(context);
    }

    public PanItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //加载视图布局
        LayoutInflater.from(context).inflate(R.layout.item_pan,this,true);

        //加载自定义的属性
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.PanItemView);
        mDesc = array.getString(R.styleable.PanItemView_pan_desc);
        mImg = array.getResourceId(R.styleable.PanItemView_pan_src,R.drawable.bangumi_sunday);

        //回收资源
        array.recycle();
    }

    public PanItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PanItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    //控件绘制完成
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        initView();
    }

    private void initView(){
        ivView = (ImageView) findViewById(R.id.iv_pan);
        tvDesc = (TextView) findViewById(R.id.tv_pan);
        gvView = (GridView) findViewById(R.id.gv_pan);

        if(!TextUtils.isEmpty(mDesc)){
            setTvDesc(mDesc);
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
}
