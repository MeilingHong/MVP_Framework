package com.meiling.mvp.view.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meiling.mvp.R;
import com.meiling.mvp.application.BaseApplication;
import com.meiling.mvp.module.datautil.CharUtil;
import com.meiling.mvp.module.datautil.log.LogUtil;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LogComponentActivity extends AppCompatActivity {


    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.clic1k)
    TextView click1;
    @BindView(R.id.click2)
    TextView click2;
    @BindView(R.id.click3)
    TextView click3;
    @BindView(R.id.click4)
    TextView click4;
    @BindView(R.id.click5)
    View click5;

    /**
     * ButterKnife 进行以来注入，对于不需要使用的组件最好不进行注入
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_component);
        ButterKnife.bind(this);

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.getInstances().e("root.setOnClickListener");
            }
        });
        click5.setEnabled(false);
        click5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recordLog("123456789");
            }
        });
    }

    private final int queueCapacity = 10000;//TODO 当限制队列的大小时使用
    private final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    private final Queue<String> errorQueue = new LinkedBlockingQueue<>(/*queueCapacity*/);

    private int recordFileCount = 1;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_");
    private String lastFileName = null;//最近一次记录时的文件名，不含文件路径
    private String lastData = null;//最近一次记录时间
    private File recordFile = null;//记录的文件
    private File recordFileDir = null;//记录文件目录
    private Date date = null;//当前时间
    private final String basePath = Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+BaseApplication.getInstances().getPackageName() + File.separator + "ErrorRecord";//外存下目录路径
    private final String suffix = ".txt";//后缀

    String[] REQUEST_PERMISSIONS_STORAGE = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    public void recordLog(String msg){
        //TODO 满足SDK条件时检查---如果权限检查不通过，给予提示，并不再进行后续的操作
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //
            boolean result = false;
            for (int i = 0; i < REQUEST_PERMISSIONS_STORAGE.length; i++) {
                result = checkSelfPermission(REQUEST_PERMISSIONS_STORAGE[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                if(result){
                    continue;
                }else{
                    break;
                }
            }
            if(!result){
                LogUtil.getInstances().e("没有完整的文件访问权限，无法进行日志记录");
                return;
            }
        }else{
            boolean result = false;
            for (int i = 0; i < REQUEST_PERMISSIONS_STORAGE.length; i++) {
                result = PermissionChecker.checkCallingOrSelfPermission(LogComponentActivity.this,REQUEST_PERMISSIONS_STORAGE[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                if(result){
                    continue;
                }else{
                    break;
                }
            }
            if(!result){
                LogUtil.getInstances().e("没有完整的文件访问权限，无法进行日志记录");
                return;
            }

        }
        errorQueue.add(msg);
        singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    //TODO 校验上一次读写的文件是否存在，且是否达到了写入大小的上限
                    try {
                        recordFileCount = 1;
                        date = new Date();
                        recordFileDir = new File(basePath);//TODO 写入时需要考虑权限的问题
                        if (!recordFileDir.exists()) {
                            recordFileDir.mkdirs();
                        }
                        LogUtil.getInstances().e("recordFileDir.exists():"+recordFileDir.exists());

                        LogUtil.getInstances().e("lastData == null:"+(lastData == null));
                        //TODO 校验并找出当前应该写入的文件
                        if (lastData == null) {
                            lastData = simpleDateFormat.format(date);//TODO 记录日期
                            lastFileName = simpleDateFormat.format(date) /*+ CharUtil.getIMEI(BaseApplication.getInstances())*/ + "_" + recordFileCount + suffix;//TODO 生成需要验证有效性的记录文件的文件名
                            recordFile = new File(recordFileDir, lastFileName);//文件名
                            LogUtil.getInstances().e("recordFile.exists()  1  :"+recordFile.exists());

                            LogUtil.getInstances().e("recordFile.getAbsolutePath()  1  :"+recordFile.getAbsolutePath());
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

                            lastFileName = simpleDateFormat.format(date) /*+ CharUtil.getIMEI(BaseApplication.getInstances())*/ + "_" + recordFileCount + suffix;//TODO 生成需要验证有效性的记录文件的文件名
                            recordFile = new File(recordFileDir, lastFileName);//文件名
                            LogUtil.getInstances().e("recordFile.exists()  2  :"+recordFile.exists());
                            LogUtil.getInstances().e("recordFile.getAbsolutePath()  2  :"+recordFile.getAbsolutePath());
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
                        if (!recordFile.exists()) {
                            //TODO 当文件不存在时，不进行记录
                            LogUtil.getInstances().e("文件不存在，终止信息的记录.");
                            return;
                        }
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(recordFile, true)), 1024);
                        LogUtil.getInstances().e("errorQueue.isEmpty() :"+errorQueue.isEmpty());
                        while (!errorQueue.isEmpty()) {
                            tempMsg = errorQueue.poll();
                            LogUtil.getInstances().e("tempMsg :"+tempMsg);
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


    @OnClick({R.id.clic1k, R.id.click2, R.id.click3, R.id.click4/*, R.id.click5*/})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            case R.id.clic1k://RuntimeException
//                throw new RuntimeException("RuntimeException");
////                break;
            case R.id.click2://InterruptException
                recordLog("123456789");
//                throw new Exception("InterruptedException");
//                break;
//            case R.id.click3://ClassCastException
//                throw new ClassCastException("ClassCastException");
////                break;
//            case R.id.click4://EOFException
////                throw new Exception("EOFException");
////                break;
//            case R.id.click5://NullPointerException
//                throw new NullPointerException("NullPointerException");
////                break;
        }
    }
}
