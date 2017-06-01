package com.meiling.mvp.application;

import android.app.Application;

import com.meiling.mvp.presenter.net.VolleyNetUtil;

/**
 * Created by john on 2017-04-21.
 */

public class BaseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();



        initVolley();
    }

    //友盟组件
    public void initUmentComponent(){

    }

    //高德组件
    public void initAMapComponent(){

    }
    //极光组件------聊天组件效果不理想
    public void initJPushComponent(){

    }

    //百度组件
    public void initBaiduComponent(){

    }

    //阿里组件
    public void initAliComponent(){

    }

    //腾讯组件
    public void initTencentComponent(){

    }

    /*
    ***********************************************
     */
    //网络访问组件
    public void initRetrofit(){

    }

    public void initVolley(){
        VolleyNetUtil.getInstances().init(this);
    }
    /*
    ***********************************************
     */
}
