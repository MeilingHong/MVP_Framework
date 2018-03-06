package com.meiling.framework.common;

import android.support.v4.app.Fragment;
import android.view.View;

import com.meiling.framework.common.interfaces.IActivity;
import com.meiling.framework.permission.interfaces.ICommonPermissionCallback;

/**
 * Created by Administrator on 12:01.
 *
 * @package com.meiling.framework
 * @auther By MeilingHong
 * @emall marisareimu123@gmail.com
 * @date 2018-02-27   12:01
 */

public abstract class BaseFragmentV4 extends Fragment implements IActivity{

    private ICommonPermissionCallback thisCallback;

    public ICommonPermissionCallback getThisCallback() {
        return thisCallback;
    }

    public void setThisCallback(ICommonPermissionCallback thisCallback) {
        this.thisCallback = thisCallback;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(thisCallback!=null){
            thisCallback.onRequestPermissionsResultCallback(requestCode, permissions, grantResults);
        }
    }

    //************************************************************
    /**
     * 默认未实现显示关闭Dialog的方法（方便根据业务需要定制显示不同的提示），
     * 其他实现为空实现，
     * 当有必要时覆盖并实现方法即可
     */

    @Override
    public View getView(int resourceID) {
        return null;
    }

    @Override
    public void setView(int resourceID, Object data) {

    }

    @Override
    public void setViewTag(int resourceID, Object data) {

    }

    @Override
    public Object getParamter(int businessCode) {
        return null;
    }

    @Override
    public void onSuccess(int businessCode, int httpResponseCode, Object result) {

    }

    @Override
    public void onError(int businessCode, int httpResponseCode, Object errorMsg) {

    }
}
