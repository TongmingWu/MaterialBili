package com.tongming.materialbili.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by Tongming on 2016/3/4.
 */
public class VerticalScrollView extends ScrollView {

    private GestureDetector mGestureDetector;
    public VerticalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mGestureDetector = new GestureDetector(context,new YScrollDetector());
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        return super.onInterceptHoverEvent(event)&&mGestureDetector.onTouchEvent(event);
    }
    class YScrollDetector extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return (Math.abs(distanceY)>Math.abs(distanceX));
        }
    }
}
