package com.acreath.starter.threadpool.endpoint;

import com.acreath.starter.threadpool.entity.ThreadPoolDetailInfo;
import com.acreath.starter.threadpool.queue.ResizeableBlockingQueue;
import com.acreath.starter.threadpool.entity.ThreadPoolInfo;
import com.acreath.starter.threadpool.util.ThreadPoolUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The type Thread pool endpoint.
 *
 * @author newrank
 */
@RestControllerEndpoint(id = "threadpool")
@Component
public class ThreadPoolEndpoint {
    @Autowired
    private ThreadPoolUtil threadPoolUtil;

    private static final ReentrantLock LOCK = new ReentrantLock();

    private static final String RESIZEABLE_BLOCKING_QUEUE = "ResizeableBlockingQueue";

    @GetMapping("getThreadPools")
    private List<String> getThreadPools (){
        List<String> threadPools = new ArrayList<>();
        if (!threadPoolUtil.getThreadPoolExecutorHashMap().isEmpty()){
            for (Map.Entry<String, ThreadPoolExecutor> entry : threadPoolUtil.getThreadPoolExecutorHashMap().entrySet()) {
                threadPools.add(entry.getKey());
            }
        }
        return threadPools;
    }

    @GetMapping("getThreadPoolFixInfo")
    private ThreadPoolInfo getThreadPoolInfo(@RequestParam String threadPoolName){
        if (threadPoolUtil.getThreadPoolExecutorHashMap().containsKey(threadPoolName)){
            ThreadPoolExecutor threadPoolExecutor = threadPoolUtil.getThreadPoolExecutorHashMap().get(threadPoolName);
            int queueCapacity = 0;
            if (RESIZEABLE_BLOCKING_QUEUE.equals(threadPoolExecutor.getQueue().getClass().getSimpleName())){
                ResizeableBlockingQueue queue = (ResizeableBlockingQueue) threadPoolExecutor.getQueue();
                queueCapacity = queue.getCapacity();
            }
            return new ThreadPoolInfo(threadPoolName,threadPoolExecutor.getCorePoolSize(),threadPoolExecutor.getMaximumPoolSize(),
                    threadPoolExecutor.getQueue().getClass().getSimpleName(),queueCapacity);
        }
        return null;
    }

    @PostMapping("setThreadPoolFixInfo")
    private Boolean setThreadPoolInfo(@RequestBody ThreadPoolInfo threadPoolInfo){
        if (threadPoolUtil.getThreadPoolExecutorHashMap().containsKey(threadPoolInfo.getThreadPoolName())){
            LOCK.lock();
            try {
                ThreadPoolExecutor threadPoolExecutor = threadPoolUtil.getThreadPoolExecutorHashMap().get(threadPoolInfo.getThreadPoolName());
                threadPoolExecutor.setMaximumPoolSize(threadPoolInfo.getMaximumPoolSize());
                threadPoolExecutor.setCorePoolSize(threadPoolInfo.getCorePoolSize());
                if (RESIZEABLE_BLOCKING_QUEUE.equals(threadPoolExecutor.getQueue().getClass().getSimpleName())){
                    ResizeableBlockingQueue queue = (ResizeableBlockingQueue) threadPoolExecutor.getQueue();
                    queue.setCapacity(threadPoolInfo.getqueueCapacity());
                }
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
            finally {
                LOCK.unlock();
            }
        }
        return false;
    }

    @GetMapping("getThreadPoolListInfo")
    private List<ThreadPoolDetailInfo> getThreadPoolListInfo(){
        List<ThreadPoolDetailInfo> detailInfoList = new ArrayList<>();
        if (!threadPoolUtil.getThreadPoolExecutorHashMap().isEmpty()){
            for (Map.Entry<String, ThreadPoolExecutor> entry : threadPoolUtil.getThreadPoolExecutorHashMap().entrySet()) {
                ThreadPoolDetailInfo threadPoolDetailInfo = threadPoolInfo(entry.getValue(),entry.getKey());
                detailInfoList.add(threadPoolDetailInfo);
            }
        }
        return  detailInfoList;
    }

    private  ThreadPoolDetailInfo threadPoolInfo(ThreadPoolExecutor threadPool,String threadPoolName) {
        BigDecimal activeCount = new BigDecimal(threadPool.getActiveCount());
        BigDecimal maximumPoolSize = new BigDecimal(threadPool.getMaximumPoolSize());
        BigDecimal  result =activeCount.divide(maximumPoolSize, 2, BigDecimal.ROUND_HALF_UP);
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(2);
        int queueCapacity = 0;
        if (RESIZEABLE_BLOCKING_QUEUE.equals(threadPool.getQueue().getClass().getSimpleName())){
            ResizeableBlockingQueue queue = (ResizeableBlockingQueue) threadPool.getQueue();
            queueCapacity = queue.getCapacity();
        }
        return new ThreadPoolDetailInfo(threadPoolName,threadPool.getPoolSize(), threadPool.getCorePoolSize(),
                threadPool.getLargestPoolSize(), threadPool.getMaximumPoolSize(), threadPool.getCompletedTaskCount(),
                threadPool.getActiveCount(),threadPool.getQueue().size(),threadPool.getKeepAliveTime(TimeUnit.MILLISECONDS),
                numberFormat.format(result.doubleValue()),queueCapacity);
    }


}
