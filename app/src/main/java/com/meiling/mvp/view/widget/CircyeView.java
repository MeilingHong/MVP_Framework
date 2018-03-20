package com.meiling.mvp.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.meiling.mvp.R;

/**
 * Created by Administrator on 14:22.
 *
 * @package com.meiling.mvp.view.widget
 * @auther By MeilingHong
 * @emall marisareimu123@gmail.com
 * @date 2018-03-09   14:22
 */

public class CircyeView extends View {

    private Context context;
    private int defaultMinSize = 100;
    private Paint mForegroundPaint;
    private Paint mBackgroundPaint;
    private RectF rectF;
    private int mForegroundColor = Color.parseColor("#ff33b5e5");
    private int mBackgroundColor = Color.parseColor("#ffffffff");
    private int ditchWidth = 30;

    private int centerX;
    private int centerY;
    private float gradient = 0.3f;

    public CircyeView(Context context) {
        super(context);
        this.context = context;
    }

    public CircyeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        getAttributeInfo(context, attrs);
    }

    public CircyeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        getAttributeInfo(context, attrs);
    }

    public void getAttributeInfo(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircyeView);//TODO 得到这个View的属性集合
        defaultMinSize = a.getDimensionPixelSize(R.styleable.CircyeView_minSize, 100);
        mForegroundColor = a.getColor(R.styleable.CircyeView_foregroundColor, Color.parseColor("#ff33b5e5"));//holo_blue
        mBackgroundColor = a.getColor(R.styleable.CircyeView_backgroundColor, Color.parseColor("#ffffffff"));//white
        ditchWidth = a.getDimensionPixelSize(R.styleable.CircyeView_ditchWidth, 30);
        gradient = a.getFloat(R.styleable.CircyeView_gradient, 0.3f);
        a.recycle();//TODO 回收资源
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getUltimateSize(defaultMinSize, widthMeasureSpec);
        int height = getUltimateSize(defaultMinSize, heightMeasureSpec);

        //TODO 使得宽高相同
        if (width < height) {
            height = width;
        } else {
            width = height;
        }

        setMeasuredDimension(width, height);
    }

    /**
     * 获取最终的大小
     *
     * @param defaultSize
     * @param measureSpec
     * @return
     */
    private int getUltimateSize(int defaultSize, int measureSpec) {
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        switch (mode) {
            case MeasureSpec.UNSPECIFIED: {
                //如果没有指定大小，就设置为默认大小mySize=defaultSize;
                return defaultSize;
            }
            case MeasureSpec.AT_MOST: {
                //如果测量模式是最大取值为size
                // 我们将大小取最大值, 你也可以取其他值mySize=size;
                return size;
            }
            case MeasureSpec.EXACTLY: {
                //如果是固定的大小，那就不要去改变它mySize=size;
                return size;
            }
            default: {
                return defaultSize;
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getCenterPoint();
        initPaint();
        canvas.drawColor(context.getResources().getColor(R.color.common_transparent));
        //TODO 使得画布旋转到正常Y轴开始
        canvas.rotate(270, centerX, centerY);

        /**
         * ******************************************************************************
         */
        //TODO 使用宽度为30的画笔一次性画出圆环
        /**
         * 绘制的圆环颜色统一，均匀
         */
//        canvas.drawArc(rectF, 0, 360, false, mBackgroundPaint);
//
//        canvas.drawArc(rectF, 3, 114, false, mForegroundPaint);
//        canvas.drawArc(rectF, 123, 114, false, mForegroundPaint);
//        canvas.drawArc(rectF, 243, 114, false, mForegroundPaint);

        /**
         * ******************************************************************************
         */
        //TODO 使用宽度为1的画笔逐步画出圆环
        /**
         * 绘制的圆环颜色不是很统一，有逐步绘制的线条感，发现打不到一步绘制完成的那种感觉
         * TODO 解决方法：通过加大画笔宽度，覆盖两次绘制的边缘，可以解决这种不协调感觉
         */
        for (int i = 2; i < ditchWidth; i++) {
            rectF = new RectF(ditchWidth * 2 / 3 + (i - 1),
                    ditchWidth * 2 / 3 + (i - 1),
                    getMeasuredWidth() - ditchWidth * 2 / 3 - (i - 1),
                    getMeasuredHeight() - ditchWidth * 2 / 3 - (i - 1));

            //TODO 画背景环（扇形）
            canvas.drawArc(rectF, 0, 360, false, mBackgroundPaint);
        }

        for (int i = 1; i < ditchWidth + 1; i++) {
            rectF = new RectF(ditchWidth * 2 / 3 + (i - 1),
                    ditchWidth * 2 / 3 + (i - 1),
                    getMeasuredWidth() - ditchWidth * 2 / 3 - (i - 1),
                    getMeasuredHeight() - ditchWidth * 2 / 3 - (i - 1));

            //TODO 画前景环（扇形）------通过移动与循环让图形显示出倾斜角度
            /**
             * 可以通过控制斜率，来让倾斜度出现不同,
             *
             * TODO 更多的部分是对canvas，paint的属性，方法设置与调用
             */
            canvas.drawArc(rectF, 3 - gradient * i, 114, false, mForegroundPaint);
            canvas.drawArc(rectF, 123 - gradient * i, 114, false, mForegroundPaint);
            canvas.drawArc(rectF, 243 - gradient * i, 114, false, mForegroundPaint);
        }
        /**
         * ******************************************************************************
         */
    }

    public void getCenterPoint() {
        centerX = getMeasuredWidth() / 2;
        centerY = getMeasuredHeight() / 2;

        rectF = new RectF(ditchWidth * 2 / 3, ditchWidth * 2 / 3, getMeasuredWidth() - ditchWidth * 2 / 3, getMeasuredHeight() - ditchWidth * 2 / 3);
    }

    public void initPaint() {
        //TODO 前景---与背景相差2个像素能遮住背景无法控制的突出部分
        mForegroundPaint = new Paint();
        mForegroundPaint.setColor(mForegroundColor);
        mForegroundPaint.setStyle(Paint.Style.STROKE);
        mForegroundPaint.setStrokeWidth(2);//TODO 使用宽度为2的画笔逐步画出圆环（增加宽度，让原来为1时两次绘制的边缘被覆盖，从而消除缝隙感觉）
//        mForegroundPaint.setStrokeWidth(30);//TODO 使用宽度为30的画笔一次性画出圆环（前景）
        mForegroundPaint.setAntiAlias(true);

        //TODO 背景
        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(mBackgroundColor);
        mBackgroundPaint.setStyle(Paint.Style.STROKE);
        mBackgroundPaint.setStrokeWidth(2);//TODO 使用宽度为2的画笔逐步画出圆环
//        mBackgroundPaint.setStrokeWidth(28);//TODO 使用宽度为28的画笔一次性画出圆环（背景）
        mBackgroundPaint.setAntiAlias(true);
    }


}
