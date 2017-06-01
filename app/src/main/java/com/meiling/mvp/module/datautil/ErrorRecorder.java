package com.meiling.mvp.module.datautil;

/**
 * Created by Administrator on 2017/4/24 0024.
 */

public class ErrorRecorder {
    //TODO 关于错误记录的问题
    /**
     * 设计：
     * 使用一个队列记录错误日志
     * 一个等待的子线程不断从队列中获取日志消息，输出到指定规则命名的错误日志文件中
     * 记录前，检查错误文件的大小，超过两兆（2M）时，重新创建一个文件进行记录  命名格式为ERR_YYYYMMDD_HHmmss
     *
     * 每个错误记录输出一行
     *
     */
}
