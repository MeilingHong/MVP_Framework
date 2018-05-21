package com.meiling.mvp.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by john on 2018-05-09.
 */

public class ConcurrentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void onConcurrentComponent(){
        CountDownLatch countDownLatch;
        Semaphore semaphore;
        Deque deque;
        BlockingDeque blockingDeque;
        CyclicBarrier cyclicBarrier;
        DelayQueue delayQueue;//TODO 周期任务或者延时任务
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(20);
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(20);
        Callable callable;
        Future future = null;
//        long timeoutTime = 60;
//        future.get(timeoutTime,TimeUnit.SECONDS);
        FutureTask futureTask;

        ExecutorCompletionService executorCompletionService;

        ExecutorService executorService = Executors.newCachedThreadPool();

        //TODO 自建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//        int corePoolSize,
                10,
//        int maximumPoolSize,
                11,
//        long keepAliveTime,
                60,
//        TimeUnit unit,
                TimeUnit.MINUTES,
//        BlockingQueue<Runnable> workQueue
                linkedBlockingQueue
        );

        //TODO 设置线程池关闭后的处理方式
        threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            }
        });

        //TODO 线程池的内部构造与调用方法
        ExecutorService service = new ExecutorService() {
            @Override
            public void shutdown() {

            }

            @NonNull
            @Override
            public List<Runnable> shutdownNow() {
                return null;
            }

            @Override
            public boolean isShutdown() {
                return false;
            }

            @Override
            public boolean isTerminated() {
                return false;
            }

            @Override
            public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @NonNull
            @Override
            public <T> Future<T> submit(Callable<T> task) {
                return null;
            }

            @NonNull
            @Override
            public <T> Future<T> submit(Runnable task, T result) {
                return null;
            }

            @NonNull
            @Override
            public Future<?> submit(Runnable task) {
                return null;
            }

            @NonNull
            @Override
            public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
                return null;
            }

            @NonNull
            @Override
            public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
                return null;
            }

            @NonNull
            @Override
            public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
                return null;
            }

            @Override
            public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }

            @Override
            public void execute(Runnable command) {

            }
        };
    }
}
