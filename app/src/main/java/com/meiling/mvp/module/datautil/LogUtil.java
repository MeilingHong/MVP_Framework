package com.meiling.mvp.module.datautil;

import android.os.Environment;
import android.util.Log;

import com.meiling.mvp.BuildConfig;
import com.meiling.mvp.application.BaseApplication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by john on 2017-04-23.
 */

public class LogUtil {

    private static LogUtil logUtil;

    private LogUtil(){

    }

    public static LogUtil getInstances(){
        if(logUtil==null){
            logUtil = new LogUtil();
        }
        return logUtil;
    }

    private static final String TAG = "MVP_Frame";
    //
    private final int LOG_LEVEL = BuildConfig.LOG_LEVEL;
    private final int LOG_V = BuildConfig.LOG_V;
    private final int LOG_D = BuildConfig.LOG_D;
    private final int LOG_I = BuildConfig.LOG_I;
    private final int LOG_W = BuildConfig.LOG_W;
    private final int LOG_E = BuildConfig.LOG_E;

    //
    private final int queueCapacity = 100000;//TODO 当限制队列的大小时使用
    private final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    private final Queue<String> errorQueue = new LinkedBlockingQueue<>(/*queueCapacity*/);

    private int recordFileCount = 1;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_");
    private String lastFileName = null;//最近一次记录时的文件名，不含文件路径
    private String lastData = null;//最近一次记录时间
    private File recordFile = null;//记录的文件
    private File recordFileDir = null;//记录文件目录
    private Date date = null;//当前时间
    private final String basePath = BaseApplication.getInstances().getPackageName() + File.separator + "ErrorRecord";//外存下目录路径
    private final String suffix = ".txt";//后缀

    //TODO 分级的日志打印
    public final void v(String msg) {
        if (LOG_V>=LOG_LEVEL && msg != null && msg.length() > 0) {
            Log.e(TAG, msg);
        }
    }

    public final void d(String msg) {
        if (LOG_D>=LOG_LEVEL && msg != null && msg.length() > 0) {
            Log.e(TAG, msg);
        }
    }

    //TODO 任意信息可以在这个等级下输出，但不建议将错误信息与需要注意的信息在这个等级下输出
    public final void i(String msg) {
        if (LOG_I>=LOG_LEVEL && msg != null && msg.length() > 0) {
            Log.e(TAG, msg);
        }
    }

    //TODO 控制这个等级下，只输出需要注意的信息
    public final void w(String msg) {
        if (LOG_W>=LOG_LEVEL &&msg != null && msg.length() > 0) {
            Log.e(TAG, msg);
        }
    }

    //TODO 控制这个等级下，只输出错误信息
    public final void e(String msg) {
        if (LOG_E>=LOG_LEVEL &&msg != null && msg.length() > 0) {
            Log.e(TAG, msg);
        }

        //TODO 若需要将错误日志记录至文件并上传
        //TODO 这里处理错误日志记录的业务
        if (BuildConfig.LOG_ERROR_SAVE_SWITCH) {
            //TODO 调用saveErrorIntoFile方法保存需要记录的错误日志
            saveErrorIntoFile(msg);
        }
    }

    /**
     * TODO 将错误等级的日志写入
     */
    public void saveErrorIntoFile(final String errorMsg) {
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
        //TODO 先校验外存是否处于挂载状态，避免由于外存状态问题导致的读写异常
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            synchronized (errorQueue) {//TODO 由于需要保证队列中数据的写入与取出的原子性，将该
                errorQueue.add(errorMsg);//TODO 将消息加入队列
                singleThreadExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        //TODO 校验上一次读写的文件是否存在，且是否达到了写入大小的上限
                        try {
                            recordFileCount = 1;
                            date = new Date();
                            recordFileDir = new File(basePath);
                            if (!recordFileDir.exists()) {
                                recordFileDir.mkdirs();
                            }
                            //TODO 校验并找出当前应该写入的文件
                            if (lastData == null) {
                                lastData = simpleDateFormat.format(date);//TODO 记录日期
                                lastFileName = simpleDateFormat.format(date) + CharUtil.getIMEI(BaseApplication.getInstances()) + "_" + recordFileCount + suffix;//TODO 生成需要验证有效性的记录文件的文件名
                                recordFile = new File(recordFileDir, lastFileName);//文件名

                                //TODO 校验得出可用的记录文件
                                while (
                                        !recordFile.exists() ||//TODO 文件不存在
                                                (recordFile.isFile() && recordFile.length() > 2 * 1024 * 1024)//TODO 是文件，但超出大小限制
                                        ) {
                                    if (!recordFile.exists()) {
                                        recordFile.createNewFile(); //TODO 文件不存在则创建
                                    } else if (recordFile.isFile() && recordFile.length() > 2 * 1024 * 1024) {
                                        recordFileCount++;
                                        lastFileName = simpleDateFormat.format(date) + CharUtil.getIMEI(BaseApplication.getInstances()) + "_" + recordFileCount + suffix;
                                        recordFile = new File(recordFileDir, lastFileName);
                                    } else {
                                        break;
                                    }
                                }
                            } else {
                                if (lastData.equals(simpleDateFormat.format(date))) {

                                } else {
                                    lastData = simpleDateFormat.format(date);//
                                }

                                lastFileName = simpleDateFormat.format(date) + CharUtil.getIMEI(BaseApplication.getInstances()) + "_" + recordFileCount + suffix;//TODO 生成需要验证有效性的记录文件的文件名
                                recordFile = new File(recordFileDir, lastFileName);//文件名

                                //TODO 校验得出可用的记录文件
                                while (
                                        !recordFile.exists() ||//TODO 文件不存在
                                                (recordFile.isFile() && recordFile.length() > 2 * 1024 * 1024)//TODO 是文件，但超出大小限制
                                        ) {
                                    if (!recordFile.exists()) {
                                        recordFile.createNewFile(); //TODO 文件不存在则创建
                                    } else if (recordFile.isFile() && recordFile.length() > 2 * 1024 * 1024) {
                                        recordFileCount++;
                                        lastFileName = simpleDateFormat.format(date) + CharUtil.getIMEI(BaseApplication.getInstances()) + "_" + recordFileCount + suffix;
                                        recordFile = new File(recordFileDir, lastFileName);
                                    } else {
                                        break;
                                    }
                                }
                            }
                            String tempMsg = null;
                            //TODO 找出了用于记录错误日志的文件
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(recordFile, true)), 1024);
                            while (!errorQueue.isEmpty()) {
                                tempMsg = errorQueue.poll();
                                if (tempMsg != null) {
                                    bufferedWriter.write(tempMsg + "\r\n");
                                    /**
                                     newLine 方法会调用系统的换行符。而这就是问题的根本。
                                     不同系统的换行符：
                                     windows -->   \r\n
                                     Linux         -->   \r
                                     mac         -->   \n
                                     */
                                    bufferedWriter.flush();
                                }
                            }
                            bufferedWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public void zipAllErrorFile() {
        stopRecordNow();
        //TODO 将目前已有的错误日志文件打包，成一个Zip文件，然后删除大过的文件
    }

    //TODO 将指定的文件上传到指定位置
    public void updataFileToServer(File updataFile){
        //TODO 考虑到不同的实际场景与要求，这个部分需要根据实际情况进行实现
    }

    public void stopRecord() {
        singleThreadExecutor.shutdown();
    }

    public void stopRecordNow() {
        singleThreadExecutor.shutdownNow();
    }
}
