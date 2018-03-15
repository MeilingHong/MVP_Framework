package com.meiling.mvp.view.widget;

/**
 * Created by Administrator on 17:01.
 *
 * @package com.meiling.mvp.view.widget
 * @auther By MeilingHong
 * @emall marisareimu123@gmail.com
 * @date 2018-03-14   17:01
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import com.meiling.mvp.module.datautil.LogUtil;

/**
 * 能够嵌套滑动的ViewGroup
 *
 * 竖直方向
 */
public class MyVerticalScrollView extends ViewGroup {
    private Scroller mScroller;
    private float mLastMotionY = 0;
    private float y;

    public MyVerticalScrollView(Context context) {
        super(context);
        initScroller(context);
    }

    public MyVerticalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initScroller(context);
    }

    public MyVerticalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initScroller(context);
    }


    public void initScroller(Context context){
        mScroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    /**
     * 根据自己的需求判断ViewGroup的大小
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //将所有的子View进行测量，这会触发每个子View的onMeasure函数
        //注意要与measureChild区分，measureChild是对单个view进行测量
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int childCount = getChildCount();

        if (childCount == 0) {//如果没有子View,当前ViewGroup没有存在的意义，不用占用空间
            setMeasuredDimension(0, 0);
        } else {
            //如果宽高都是包裹内容
            if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) { //我们将高度设置为所有子View的高度相加，宽度设为子View中最大的宽度
                int height = getTotleHeight();
                int width = getMaxChildWidth();
                setMeasuredDimension(width, height);
            } else if (heightMode == MeasureSpec.AT_MOST) {
                //如果只有高度是包裹内容
                // 宽度设置为ViewGroup自己的测量宽度，高度设置为所有子View的高度总和
                setMeasuredDimension(widthSize, getTotleHeight());
            } else if (widthMode == MeasureSpec.AT_MOST) {
                //如果只有宽度是包裹内容 //宽度设置为子View中宽度最大的值，高度设置为ViewGroup自己的测量值
                setMeasuredDimension(getMaxChildWidth(), heightSize);
            } else {
                //TODO 避免未处理这种情况，导致显示上的异常
                setMeasuredDimension(widthSize, heightSize);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                mLastMotionY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float delt = mLastMotionY - y;
                mLastMotionY = y;
//                if(delt<0){
//                    delt = 0;
//                }else if(delt>getTotleHeight()){
//                    delt = getTotleHeight();
//                }
                /**
                 * TODO 如何确定第一个子View上边界（需要将Margin计算进去）到了容器顶部
                 *
                 * TODO 如何确定最后一个View下边界（需要将Margin计算进去）到了容器底部
                 */
                scrollBy( 0, (int)delt);
                break;
            case MotionEvent.ACTION_UP:
                invalidate();
                break;

            default:
                break;
        }
        return true;
    }

    /***
     * 获取子View中宽度最大的值
     */
    private int getMaxChildWidth() {
        int childCount = getChildCount();
        int maxWidth = 0;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
//            LayoutParams marginLayoutParams = childView.getLayoutParams();//这个属性中没有Margin
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childView.getLayoutParams();
            if (childView.getMeasuredWidth() > maxWidth) {
                maxWidth = childView.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            } else {
                maxWidth = childView.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            }
        }
        return maxWidth;
    }

    /***
     * 将所有子View的高度相加
     **/
    private int getTotleHeight() {
        int childCount = getChildCount();
        int height = 0;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childView.getLayoutParams();
            height += childView.getMeasuredHeight()+marginLayoutParams.topMargin+marginLayoutParams.bottomMargin;
        }
        return height;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int count = getChildCount(); //记录当前的高度位置
        int curHeight = top; //将子View逐个摆放
        LogUtil.getInstances().e("onLayout left:"+left+"\ntop:"+top+"\nright:"+right+"\nbottom:"+bottom);
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            int height = child.getMeasuredHeight();
            int width = child.getMeasuredWidth(); //摆放子View，参数分别是子View矩形区域的左、上、右、下边
            child.layout(left+getPaddingLeft(), curHeight+getPaddingTop(), left + width, curHeight + height);//TODO 靠左，逐个摆放，高度逐步增加
            curHeight += height;
        }
    }
}
