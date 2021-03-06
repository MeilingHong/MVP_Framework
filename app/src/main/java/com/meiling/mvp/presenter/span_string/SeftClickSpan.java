package com.meiling.mvp.presenter.span_string;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/**
 * 自定义的SpanString类，实现特定的点击效果
 * Created by Administrator on 2016/12/16 0016.
 */

public class SeftClickSpan extends ClickableSpan {
    private Context context;
    private String textColor = "#ff999999";
    private int bgColor;
    private boolean showUnderline;
    private View.OnClickListener clickListener;

    public SeftClickSpan(){

    }

    public SeftClickSpan(Context context, String textColor, int bgColor, boolean showUnderline, View.OnClickListener clickListener) {
        this.context = context;
        this.textColor = textColor;
        this.bgColor = bgColor;
        this.showUnderline = showUnderline;
        this.clickListener = clickListener;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        //
        if(context!=null){
            ds.setColor(Color.parseColor(textColor));
            ds.bgColor = context.getResources().getColor(bgColor);
            ds.setUnderlineText(showUnderline);
        }else{
            ds.setColor(Color.parseColor("#ff999999"));
            ds.bgColor = 0x00ffffff;
            ds.setUnderlineText(false);
        }
//        ds.clearShadowLayer();
    }

    @Override
    public void onClick(View widget) {
        if(clickListener!=null){
            clickListener.onClick(widget);
        }
    }
}
