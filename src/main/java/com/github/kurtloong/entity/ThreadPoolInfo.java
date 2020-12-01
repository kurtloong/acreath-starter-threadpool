package com.github.kurtloong.entity;

/**
 * The type Thread pool info.
 */
public class ThreadPoolInfo {
    private String threadPoolName;
    private int corePoolSize;
    private int maximumPoolSize;
    private String queueType;
    private int queueCapacity;

    /**
     * Instantiates a new Thread pool info.
     *
     * @param threadPoolName  the thread pool name
     * @param corePoolSize    the core pool size
     * @param maximumPoolSize the maximum pool size
     * @param queueType       the queue type
     * @param queueCapacity   the queue capacity
     */
    public ThreadPoolInfo(String threadPoolName, int corePoolSize, int maximumPoolSize, String queueType, int queueCapacity) {
        this.threadPoolName = threadPoolName;
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.queueType = queueType;
        this.queueCapacity = queueCapacity;
    }

    /**
     * Gets thread pool name.
     *
     * @return the thread pool name
     */
    public String getThreadPoolName() {
        return threadPoolName;
    }

    /**
     * Sets thread pool name.
     *
     * @param threadPoolName the thread pool name
     */
    public void setThreadPoolName(String threadPoolName) {
        this.threadPoolName = threadPoolName;
    }

    /**
     * Gets core pool size.
     *
     * @return the core pool size
     */
    public int getCorePoolSize() {
        return corePoolSize;
    }

    /**
     * Sets core pool size.
     *
     * @param corePoolSize the core pool size
     */
    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    /**
     * Gets maximum pool size.
     *
     * @return the maximum pool size
     */
    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    /**
     * Sets maximum pool size.
     *
     * @param maximumPoolSize the maximum pool size
     */
    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    /**
     * Gets queue type.
     *
     * @return the queue type
     */
    public String getQueueType() {
        return queueType;
    }

    /**
     * Sets queue type.
     *
     * @param queueType the queue type
     */
    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    /**
     * Gets capacity.
     *
     * @return the capacity
     */
    public int getqueueCapacity() {
        return queueCapacity;
    }

    /**
     * Sets capacity.
     *
     * @param queueCapacity the queue capacity
     */
    public void setqueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }
}
