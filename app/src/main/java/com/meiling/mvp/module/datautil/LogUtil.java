package com.meiling.mvp.module.datautil;

import android.util.Log;

import com.meiling.mvp.BuildConfig;

/**
 * Created by john on 2017-04-23.
 */

public class LogUtil {
    private static final String TAG = "MVP_Frame";
    //
    private final int LOG_LEVEL = BuildConfig.LOG_LEVEL;
    private final int LOG_V = BuildConfig.LOG_V;
    private final int LOG_D = BuildConfig.LOG_D;
    private final int LOG_I = BuildConfig.LOG_I;
    private final int LOG_W = BuildConfig.LOG_W;
    private final int LOG_E = BuildConfig.LOG_E;

    //TODO 分级的日志打印
    public static final void v(String msg){
        if(msg!=null && msg.length()>0){
            Log.e(TAG,msg);
        }
    }
    public static final void d(String msg){
        if(msg!=null && msg.length()>0){
            Log.e(TAG,msg);
        }
    }

    //TODO 任意信息可以在这个等级下输出，但不建议将错误信息与需要注意的信息在这个等级下输出
    public static final void i(String msg){
        if(msg!=null && msg.length()>0){
            Log.e(TAG,msg);
        }
    }
    //TODO 控制这个等级下，只输出需要注意的信息
    public static final void w(String msg){
        if(msg!=null && msg.length()>0){
            Log.e(TAG,msg);
        }
    }
    //TODO 控制这个等级下，只输出错误信息
    public static final void e(String msg){
        if(msg!=null && msg.length()>0){
            Log.e(TAG,msg);
        }

        //TODO 若需要将错误日志记录至文件并上传
        //TODO 这里处理错误日志记录的业务
        if(BuildConfig.LOG_ERROR_SAVE_SWITCH){
            //TODO 调用saveErrorIntoFile方法保存需要记录的错误日志
        }
    }

    /**
     * TODO 将错误等级的日志写入
     */
    public void saveErrorIntoFile(String errorMsg){
        /**
         * TODO 先检查文件是否存满----每个文件限制大小为2M
         *
         * 文件命名格式为 yyyy-MM-dd_imei（IMEI其实只是用于区分设备，若实际满足不了需求，建议修改命名方式，例如：用户编号等
         * 部分错误可能会跟用户有关，怎么进行去进行区分，建议仔细想好再做）_第几份记录（从1开始，当一个文件存满后，依次递增）
         *
         * 使用一个队列保存需要写入的日志错误信息
         *
         * 使用单线程的线程池控制日志写入线程
         *
         * 是否重新启动日志写入线程判断条件：
         *  队列中当前已经没有了可以进行写入的信息，则将当前消息写入队列，启动线程，写入文件；
         *  若队列中仍然有信息，则直接插入队列中（写入线程将以串行方式将队列中的消息写入，直至队列为空，则停止线程）
         *  队列为单一队列，并且仅做保存需要写入的错误日志，
         *  写入线程不断从队列中取出消息，并写入
         */

    }
}
