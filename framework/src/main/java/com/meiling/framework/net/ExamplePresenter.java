package com.meiling.framework.net;

import android.support.annotation.NonNull;

import com.meiling.framework.common.BaseActivity;
import com.meiling.framework.common.interfaces.IActivity;
import com.meiling.framework.net.interfaces.IPresenter;

import java.util.HashMap;

/**
 * Created by Administrator on 16:05.
 *
 * @package com.meiling.framework.net
 * @auther By MeilingHong
 * @emall marisareimu123@gmail.com
 * @date 2018-03-05   16:05
 */

public class ExamplePresenter implements IPresenter<BaseActivity>{

    @Override
    public void doBusiness(@NonNull IActivity activity, @NonNull int businessCode,BaseActivity activityCallback) {
        switch (businessCode){
            case 1:{
                doBusiness_1(activityCallback);
                break;
            }
            case 2:{
                doBusiness_2(activityCallback);
                break;
            }
        }
    }
    //**************************************************
    /**
     * 这里为做业务流程1的调用，当业务流程能够细分成更小的步骤时，
     * 拆分成更多的方法调用，组合直至完成这个业务流程
     */
    private void doBusiness_1(BaseActivity baseActivity){
        doSubBusiness_1_1(baseActivity);
        doSubBusiness_1_2(baseActivity);
    }
    private void doSubBusiness_1_1(BaseActivity baseActivity){

    }
    private void doSubBusiness_1_2(BaseActivity baseActivity){

    }
    //.....................

    //**************************************************
    private void doBusiness_2(BaseActivity baseActivity){
        doSubBusiness_2_1(baseActivity);
        doSubBusiness_2_2(baseActivity);
    }

    private void doSubBusiness_2_1(BaseActivity baseActivity){

    }
    private void doSubBusiness_2_2(BaseActivity baseActivity){

    }
}
