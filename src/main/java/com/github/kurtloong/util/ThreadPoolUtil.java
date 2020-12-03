package com.github.kurtloong.util;

import com.github.kurtloong.ThreadPoolMonitor;
import com.github.kurtloong.queue.ResizeableBlockingQueue;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class ThreadPoolUtil {
    private final HashMap<String, ThreadPoolMonitor> threadPoolExecutorHashMap = new HashMap<>();

    public ThreadPoolMonitor creatThreadPool (int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                               TimeUnit unit, BlockingQueue<Runnable> workQueue, String poolName){
        ThreadPoolMonitor threadPoolExecutor = new ThreadPoolMonitor(corePoolSize,maximumPoolSize,keepAliveTime,unit,workQueue,poolName);
        threadPoolExecutorHashMap.put(poolName,threadPoolExecutor);
        return threadPoolExecutor;
    }

    public ThreadPoolMonitor creatThreadPool (int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                               TimeUnit unit ,int queueSize, String poolName){
        ThreadPoolMonitor threadPoolExecutor = new ThreadPoolMonitor(corePoolSize,maximumPoolSize,keepAliveTime,unit,new ResizeableBlockingQueue<>(queueSize),poolName);
        threadPoolExecutorHashMap.put(poolName,threadPoolExecutor);
        return threadPoolExecutor;
    }

    public HashMap<String, ThreadPoolMonitor> getThreadPoolExecutorHashMap() {
        return threadPoolExecutorHashMap;
    }
}
