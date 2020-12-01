package com.acreath.starter.threadpool.util;

import com.acreath.starter.threadpool.ThreadPoolMonitor;
import com.acreath.starter.threadpool.queue.ResizeableBlockingQueue;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class ThreadPoolUtil {
    private final HashMap<String, ThreadPoolExecutor> threadPoolExecutorHashMap = new HashMap<>();

    public ThreadPoolExecutor creatThreadPool (int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                               TimeUnit unit, BlockingQueue<Runnable> workQueue, String poolName){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolMonitor(corePoolSize,maximumPoolSize,keepAliveTime,unit,workQueue,poolName);
        threadPoolExecutorHashMap.put(poolName,threadPoolExecutor);
        return threadPoolExecutor;
    }

    public ThreadPoolExecutor creatThreadPool (int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                               TimeUnit unit ,int queueSize, String poolName){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolMonitor(corePoolSize,maximumPoolSize,keepAliveTime,unit,new ResizeableBlockingQueue<>(queueSize),poolName);
        threadPoolExecutorHashMap.put(poolName,threadPoolExecutor);
        return threadPoolExecutor;
    }

    public HashMap<String, ThreadPoolExecutor> getThreadPoolExecutorHashMap() {
        return threadPoolExecutorHashMap;
    }
}
