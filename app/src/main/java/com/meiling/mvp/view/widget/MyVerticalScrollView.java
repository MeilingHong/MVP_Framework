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
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

import com.meiling.mvp.module.datautil.LogUtil;

/**
 * 能够嵌套滑动的ViewGroup
 * <p>
 * 竖直方向
 */
public class MyVerticalScrollView extends ViewGroup {
    /**
     * Scroller/OverScroller  的简单实用步骤
     * TODO 1、声明并初始化一个Scroller/OverScroller
     * TODO 2、通过onLayout 获取View的边界（上下边界，左右边界）
     * TODO 3、设置拦截触摸事件onInterceptTouchEvent(MotionEvent ev)，当触摸事件达到魔盖特定条件时，进行拦截【即ViewGroup需要进行滑动时的条件】
     * TODO 4、在onTouchEvent方法中进行条件判断，在ACTION_UP中，开始滚动（需要注意与ACTION_MOVE中的处理的冲突）
     * TODO
     * TODO
     * TODO
     * TODO
     * TODO
     */
    private Scroller mScroller;
    private float mLastMotionY = 0;
    private float delt;
    private float y;
    private float mTotalMotionY = 0;
    //http://blog.csdn.net/lib739449500/article/details/51850276
    //TODO 边界值需要在onLayout中计算得到后保存下来，后面再次调用
    private float firstChildTopBound;
    private float lastChildBottomBound;

    /**
     * 判定为拖动的最小移动像素数
     */
    private int mTouchSlop;

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


    public void initScroller(Context context) {
        mScroller = new Scroller(context);
        //TODO 得到最小有效滑动距离----似乎是系统默认值
        ViewConfiguration configuration = ViewConfiguration.get(context);
        // 获取TouchSlop值
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
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
                getMaxChildWidth();
            } else if (widthMode == MeasureSpec.AT_MOST) {
                //如果只有宽度是包裹内容 //宽度设置为子View中宽度最大的值，高度设置为ViewGroup自己的测量值
                setMeasuredDimension(getMaxChildWidth(), heightSize);
                getTotleHeight();
            } else {
                //TODO 避免未处理这种情况，导致显示上的异常
                setMeasuredDimension(widthSize, heightSize);
            }
        }
    }


    /**
     * event.getX():表示的是触摸的点距离自身左边界的距离
     * event.getY():表示的是触摸的点距离自身上边界的距离
     * event.getRawX:表示的是触摸点距离屏幕左边界的距离
     * event.getRawY:表示的是触摸点距离屏幕上边界的距离
     * <p>
     * scrollTo（int x,int y） 移动到指定位置（x,y）
     * <p>
     * scrollBy(int x,int y) 在当前位置基础上移动距离，分别为X方向上（水平方向/左右），Y方向上(竖直方向/上下)
     */
    //TODO 由于本身涉及到子控件，当自身需要进行滑动时，需要对子控件的事件进行拦截（避免可滑动的子控件与可滑动的父控件出现滑动冲突）
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                mLastMotionY = ev.getY();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                y = ev.getY();
                float diff = mLastMotionY - y;
                if (diff > mTouchSlop) {//TODO 当移动距离大于最小距离时拦截子控件的时间
                    return true;
                }
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    /**
     * https://www.jianshu.com/p/293d0c2f56cb
     * http://ztelur.github.io/2016/03/16/Android-MotionEvent%E8%AF%A6%E8%A7%A3/
     * http://ztelur.github.io/2016/03/27/Android-Scroll%E8%AF%A6%E8%A7%A3-%E4%B8%80-%EF%BC%9A%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/
     * http://ztelur.github.io/2016/02/11/%E5%9B%BE%E8%A7%A3Android%E4%BA%8B%E4%BB%B6%E4%BC%A0%E9%80%92%E4%B9%8BViewGroup%E7%AF%87/
     * http://ztelur.github.io/2016/02/04/%E5%9B%BE%E8%A7%A3Android%E4%BA%8B%E4%BB%B6%E4%BC%A0%E9%80%92%E4%B9%8BView%E7%AF%87/
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 1、得到最小滑动距离，在MOVE时进行判断，当偏移差值大于这个最小值时，进行滑动处理（即拦截向子控件分发事件），否则不进行滑动
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                /**
                 * //TODO 实际操作中发现，按照1:1的比例滑动，似乎速度有点快
                 * //TODO 降低便宜比例，似乎能让滑动看起来更加流畅
                 */
                delt = (mLastMotionY - y)/10.0f;
                /**
                 * TODO 如何确定第一个子View上边界（需要将Margin计算进去）到了容器顶部
                 * TODO 如何确定最后一个View下边界（需要将Margin计算进去）到了容器底部
                 *
                 * 刷新View并没有触发使得View重新走onLayout方法，
                 *
                 * 针对滑动，需要自己记录当前滚动距离，总滚动距离的偏移值
                 *
                 *
                 *  偏移数值与方向的关系
                 *  向上移动为正，向下移动为负
                 *
                 *  存在的问题，由于一次滑动的Motion不一定能刚好滑动到顶部与底部的位置，所以最后的一次scrollBy(0, (int) delt)
                 *  调用，可能会使得滑动的距离不够，或者超过了控制的距离
                 */

                if (getScrollY() + delt <= firstChildTopBound) {
                    if (delt >= 0) {//TODO 控制移动更加平滑
                        mTotalMotionY += delt;//用来记录每一个的偏移总和，得到从初始位置当当前位置的偏移
                    }
                    scrollTo(0,/*(int)(-mTotalMotionY)*/(int)firstChildTopBound);//向下移动到了顶部子View显示出来了，就不在移动
                    //TODO 由于存在一个范围，需要进行调整所以应该进行回滚偏差值的距离，否则可能出现计算与实际显示不一致的情况
                    LogUtil.getInstances().e("getScrollY() + delt <= firstChildTopBound");
                    break;
                } else if (getScrollY() + delt +getHeight() > lastChildBottomBound) {
                    scrollTo(0, /*(int)(-(mTotalMotionY-(lastChildBottomBound - getMeasuredHeight())))*/(int) lastChildBottomBound - getHeight());//向上滚动到了最后一个子View的下边界显示出来了 TODO 当滚动到下边界时，应该是不再进行滚动，而不是再滚动600（这个逻辑错了）的距离，
                    LogUtil.getInstances().e("getScrollY() + delt +getHeight() > lastChildBottomBound");
                    break;
                } else {
                    mTotalMotionY += delt;//用来记录每一个的偏移总和，得到从初始位置当当前位置的偏移
                    scrollBy(0, (int) delt);//TODO 这里的移动不会管容器View或者子View当前的位置，所以需要使用其他的数据来控制对这个操纵的调用
                    LogUtil.getInstances().e("scrollBy(0, (int) delt)：" + delt);
                    break;
                }
            case MotionEvent.ACTION_UP:
                mScroller.startScroll(0, getScrollY(), 0, (int) (mLastMotionY - y));
//                LogUtil.getInstances().e("ACTION_UP  getScrollY()：" + getScrollY()+"\nmLastMotionY - y:"+(mLastMotionY - y));
                invalidate();
                break;

            default:
                break;
        }
        return true;
    }

    /**
     * http://blog.csdn.net/lib739449500/article/details/51850276
     * Android Scroller OverScroller使用
     */
    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
//            if((((int) lastChildBottomBound - getMeasuredHeight())//TODO 可滚动到的最下位置
//                    - mScroller.getCurrY())>0 &&
//                    mScroller.getCurrY()>0){//TODO 没有滚动到最下面
////                scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
//                LogUtil.getInstances().e("computeScroll mScroller.getCurrX()：" + mScroller.getCurrX()+"mScroller.getCurrY():"+mScroller.getCurrY()+"\n\n\n");
//                postInvalidate();
//            }else{
//                postInvalidate();
//                return;
//            }
            LogUtil.getInstances().e("computeScroll mScroller.getCurrX()：" + mScroller.getCurrX()+"\nmScroller.getCurrY():"+mScroller.getCurrY()+"\n\n\n");
        }
    }

    /***
     * 获取子View中宽度最大的值
     */
    private int getMaxChildWidth() {
        int childCount = getChildCount();
        int maxWidth = 0;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            /*MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childView.getLayoutParams();*/
            if (childView.getMeasuredWidth() > maxWidth) {
                maxWidth = childView.getMeasuredWidth()/* + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin*/;
            } else {
                maxWidth = childView.getMeasuredWidth()/* + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin*/;
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
            /*MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childView.getLayoutParams();*/
            height += childView.getMeasuredHeight()/* + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin*/;
        }
//        LogUtil.getInstances().e("firstChildTopBound:" + firstChildTopBound + "\n" +
//                "lastChildBottomBound:" + lastChildBottomBound);
        return height;
    }

    /**
     * 参数的上下左右标识的是屏幕的宽高
     *
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int count = getChildCount(); //记录当前的高度位置
        int curHeight = top; //将子View逐个摆放
        LogUtil.getInstances().e("onLayout left:" + left + "\ntop:" + top + "\nright:" + right + "\nbottom:" + bottom);
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            int height = child.getMeasuredHeight();
            int width = child.getMeasuredWidth(); //摆放子View，参数分别是子View矩形区域的左、上、右、下边
            child.layout(left + getPaddingLeft(), curHeight + getPaddingTop(), left + width, curHeight + height);//TODO 靠左，逐个摆放，高度逐步增加
            curHeight += height;
            if (i == 0) {
                firstChildTopBound = child.getTop();
            } else if (i == count - 1) {
                lastChildBottomBound = child.getBottom();
            }
        }
        /**
         * 可以通过onLayout计算得到View的上下边界
         */
        LogUtil.getInstances().e("firstChildTopBound:" + firstChildTopBound + "\n" +
                "lastChildBottomBound:" + lastChildBottomBound);
    }


}
