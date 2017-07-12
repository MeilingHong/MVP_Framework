package com.meiling.mvp.view;

import android.view.View;

/**
 * Created by john on 2017-04-21.
 */

public interface IActivity {
    //TODO 类型根据需要进行扩展，需求是变动的，不要固化只用这几种
    enum ViewTYPE{
        TEXT,INPUT,IMAGE,LISTVIEW
    }
    //TODO 应该有更好的
    View getView(int resourceID);
    void setView(int resourceID,ViewTYPE viewTYPE,Object data);
    void setViewTag(int resourceID,ViewTYPE viewTYPE,Object data);
    Object getParamter(int type);
    void showMyDialog(int type);
    void dismissMyDialog(int type);
    void onSuccess(int type,int httpResponseCode,Object result);
    void onError(int type,int httpResponseCode,Object errorMsg);
}
