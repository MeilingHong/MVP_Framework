package com.meiling.mvp.application;

import android.app.Application;

import com.meiling.mvp.module.datautil.log.LogUtil;

/**
 * Created by john on 2017-04-21
 */

public class BaseApplication extends Application{

    private static BaseApplication instances;

    public static BaseApplication getInstances(){
        return instances;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;

//        logComponent();
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
    /*
    ***********************************************
     */
    public void logComponent(){
        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //TODO 输出栈信息----日常的异常输出的信息
                StringBuilder stringBuilder = new StringBuilder();
                for (StackTraceElement element : e.getStackTrace()){
                    stringBuilder.append(element.getClassName()+" . ");
                    stringBuilder.append(element.getMethodName() +" (");
                    stringBuilder.append(element.getFileName()+" : ");
                    stringBuilder.append(element.getLineNumber()+" )");
                    stringBuilder.append("\n");
                }
                //TODO
                LogUtil.getInstances().e(t.getName()+
                        "\n"+e.getLocalizedMessage()+
                        "\nStackInfo:\n"+stringBuilder.toString()+
                        "\n");

                System.exit(0);//TODO 直接退出进程
                //TODO 重新启动页面-------------启动不成功
//                BaseApplication.getInstances().startActivity(new Intent(BaseApplication.getInstances(), MainActivity2.class));
            }
        });
    }
    /*
    ***********************************************
     */
}
