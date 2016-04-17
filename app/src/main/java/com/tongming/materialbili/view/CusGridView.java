package com.tongming.materialbili.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Tongming on 2016/3/23.
 */
public class CusGridView extends GridView {

    private boolean flag = false;

    public CusGridView(Context context) {
        super(context);
    }

    public CusGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CusGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CusGridView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(2000, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        flag = true;
    }

    @Override
    public void requestLayout() {
        if(flag){
            return;
        }
        super.requestLayout();
    }

}
