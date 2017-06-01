package com.meiling.mvp.presenter.net;

/**
 * Created by Administrator on 2017/4/24 0024.
 */

public interface INetAccessResult {
    int SUCCESS = 1;//接口访问正常，获取了正确的结果
    int FAILURE = 2;//接口访问正常，但是错误的结果
    int EXCEPTION = 3;//接口访问失败，【根据错误的类型，对应相应的异常，给出相应的提示】

    /**
     * @param resultType 对应上面的结果类型
     * @param result 返回的结果
     * @param message 当访问完成是，可以进行提示的信息
     */
    void onNetResult(int resultType, String result, String message);
//    void onNetResult(int resultType,Object result,String message);
}
