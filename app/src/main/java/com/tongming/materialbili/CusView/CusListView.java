package com.tongming.materialbili.CusView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Tongming on 2016/4/13.
 */
public class CusListView extends ListView {

    private boolean flag = false;
    public CusListView(Context context) {
        super(context);
    }

    public CusListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CusListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CusListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2, MeasureSpec.AT_MOST);
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
