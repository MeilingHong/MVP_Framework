package com.meiling.framework.common.interfaces;

import android.view.View;

/**
 * Created by john on 2017-04-21.
 */

public interface IActivity<T> {
    //TODO 应该有更好的
    View getView(int resourceID);// 虽然可以考虑泛型，但由于业务本身存在复杂的情况，调用方法存在不同的返回值
    void setView(int resourceID,Object data);
    void setViewTag(int resourceID,Object data);
    //TODO 下面方法为进行网络访问时，可能需要进行调用的回调方法
    T getParamter(int businessCode);
    void showMyDialog(int businessCode);
    void dismissMyDialog(int businessCode);
    void onSuccess(int businessCode,int httpResponseCode,Object result);
    void onError(int businessCode,int httpResponseCode,Object errorMsg);
}
