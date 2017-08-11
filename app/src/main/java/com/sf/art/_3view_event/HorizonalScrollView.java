package com.sf.art._3view_event;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by Finltop on 2017/8/11.
 */

public class HorizonalScrollView extends ViewGroup {
    Context mContext;
    Scroller mScroller;
    int lastInterceptX = 0;
    int lastInterceptY = 0;
    int lastX = 0;
    int lastY = 0;
    VelocityTracker velocityTracker = null;

    private int mChildrenSize;
    private int mChildrenIndex;
    private int mChildrenWidth;

    public HorizonalScrollView(Context context) {
        this(context, null, -1);

    }

    public HorizonalScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public HorizonalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mContext = context;
        mScroller = new Scroller(context);
        velocityTracker = VelocityTracker.obtain();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int childCount = getChildCount();
        int childLeft = 0;
        mChildrenSize = childCount;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getVisibility() != GONE) {
                final int childWidth = getMeasuredWidth();
                mChildrenWidth = childWidth;
                childView.layout(childLeft, 0, childLeft + mChildrenWidth, childView.getMeasuredHeight());
                childLeft += childWidth;
            }
        }

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean isIntercept = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isIntercept = false;
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                    isIntercept = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - lastInterceptX;
                int deltaY = y - lastInterceptY;
                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    isIntercept = true;
                } else {
                    isIntercept = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                isIntercept = false;
                break;

        }
        lastInterceptX = x;
        lastInterceptY = y;
        return isIntercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) getX();
        int y = (int) getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int delatX = x - lastX;
                int delatY = y - lastY;
                scrollBy(delatX, 0);
                break;
            case MotionEvent.ACTION_UP:
                int scrollX=getScrollX();
                int scrollToChildIndex=scrollX/mChildrenWidth;
                velocityTracker.computeCurrentVelocity(1000);
                float xVelocity=velocityTracker.getXVelocity();
                if(Math.abs(xVelocity)>=50){
                    mChildrenIndex=xVelocity>0?mChildrenIndex-1:mChildrenIndex+1;
                }else{
                    mChildrenIndex=(scrollX+mChildrenWidth/2)/mChildrenWidth;
                }
                mChildrenIndex=Math.max(0,Math.min(mChildrenIndex,mChildrenSize-1));
                int dx=mChildrenIndex*mChildrenWidth-scrollX;
                smoothScrollBy(dx,0);
                velocityTracker.clear();
                break;
        }
        lastX = x;
        lastY = y;
        return true;
    }
    private void smoothScrollBy(int dx, int dy) {
        mScroller.startScroll(getScrollX(), 0, dx, 0, 500);
        invalidate();
    }

    @Override
    protected void onDetachedFromWindow() {
        velocityTracker.recycle();
        super.onDetachedFromWindow();
    }
}





























