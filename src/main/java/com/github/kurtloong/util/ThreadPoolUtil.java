package com.github.kurtloong.util;

import com.github.kurtloong.ThreadPoolMonitor;
import com.github.kurtloong.queue.ResizeableBlockingQueue;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * The type Thread pool util.
 * 线程池工具类
 */
@Component
public class ThreadPoolUtil {
    /**
     * 通过Hash去指向创建的线程池，之后可以通过这个HashMap去获取线程池
     */
    private final HashMap<String, ThreadPoolMonitor> threadPoolExecutorHashMap = new HashMap<>();

    /**
     * Creat thread pool thread pool monitor.
     *
     * 可以自定义队列类型的构造器
     *
     * @param corePoolSize    the core pool size
     * @param maximumPoolSize the maximum pool size
     * @param keepAliveTime   the keep alive time
     * @param unit            the unit
     * @param workQueue       the work queue
     * @param poolName        the pool name
     * @return the thread pool monitor
     */
    public ThreadPoolMonitor creatThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                             TimeUnit unit, BlockingQueue<Runnable> workQueue, String poolName) {
        ThreadPoolMonitor threadPoolExecutor = new ThreadPoolMonitor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, poolName);
        threadPoolExecutorHashMap.put(poolName, threadPoolExecutor);
        return threadPoolExecutor;
    }

    /**
     * Creat thread pool thread pool monitor.
     *
     * ResizeableBlockingQueue 里面修改了capacity参数
     * 可以通过set方法去修改队列的大小
     * 使用默认队列的构造器
     *
     * @param corePoolSize    the core pool size
     * @param maximumPoolSize the maximum pool size
     * @param keepAliveTime   the keep alive time
     * @param unit            the unit
     * @param queueSize       the queue size
     * @param poolName        the pool name
     * @return the thread pool monitor
     */
    public ThreadPoolMonitor creatThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                             TimeUnit unit, int queueSize, String poolName) {
        ThreadPoolMonitor threadPoolExecutor = new ThreadPoolMonitor(corePoolSize, maximumPoolSize, keepAliveTime, unit, new ResizeableBlockingQueue<>(queueSize), poolName);
        threadPoolExecutorHashMap.put(poolName, threadPoolExecutor);
        return threadPoolExecutor;
    }

    /**
     * Gets thread pool executor hash map.
     *
     * @return the thread pool executor hash map
     */
    public HashMap<String, ThreadPoolMonitor> getThreadPoolExecutorHashMap() {
        return threadPoolExecutorHashMap;
    }
}
