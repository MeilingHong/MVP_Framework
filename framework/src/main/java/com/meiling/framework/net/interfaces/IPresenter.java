package com.meiling.framework.net.interfaces;

import android.content.Context;
import android.support.annotation.NonNull;

import com.meiling.framework.common.interfaces.IActivity;

/**
 * Created by Administrator on 16:06.
 *
 * @package com.meiling.framework.net.interfaces
 * @auther By MeilingHong
 * @emall marisareimu123@gmail.com
 * @date 2018-03-05   16:06
 */

public interface IPresenter<T extends Context> {
    /**
     * 通过activity得到实际显示页面的实现，
     * 并通过回调方法得到业务参数getParamter
     * 通过回调方法showMyDialog/dismissMyDialog显示或关闭提示对话框
     * 通过回调方法onSuccess/onError来
     *
     * @param activity
     * @param businessCode
     * @param activityContext 通过指定特定的Presenter来调用一些特定的方法，获取/设置特定数据
     */
    void doBusiness(@NonNull final IActivity activity,@NonNull int businessCode,@NonNull T activityContext);
}
