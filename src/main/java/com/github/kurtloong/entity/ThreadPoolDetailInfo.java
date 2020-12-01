package com.github.kurtloong.entity;

/**
 * The type Thread pool detail info.
 */
public class ThreadPoolDetailInfo {
    private String threadPoolName;
    private Integer poolSize;
    private Integer corePoolSize;
    private Integer largestPoolSize;
    private Integer maximumPoolSize;
    private long completedTaskCount;
    private Integer active;
    private Integer task;
    private long keepAliveTime;
    private String activePercent;
    private Integer queueCapacity;

    /**
     * Instantiates a new Thread pool detail info.
     *
     * @param threadPoolName     the thread pool name
     * @param poolSize           the pool size
     * @param corePoolSize       the core pool size
     * @param largestPoolSize    the largest pool size
     * @param maximumPoolSize    the maximum pool size
     * @param completedTaskCount the completed task count
     * @param active             the active
     * @param task               the task
     * @param keepAliveTime      the keep alive time
     * @param activePercent      the active percent
     * @param queueCapacity      the queue capacity
     */
    public ThreadPoolDetailInfo(String threadPoolName, Integer poolSize, Integer corePoolSize, Integer largestPoolSize, Integer maximumPoolSize, long completedTaskCount, Integer active, Integer task, long keepAliveTime, String activePercent, Integer queueCapacity) {
        this.threadPoolName = threadPoolName;
        this.poolSize = poolSize;
        this.corePoolSize = corePoolSize;
        this.largestPoolSize = largestPoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.completedTaskCount = completedTaskCount;
        this.active = active;
        this.task = task;
        this.keepAliveTime = keepAliveTime;
        this.activePercent = activePercent;
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
     * Gets pool size.
     *
     * @return the pool size
     */
    public Integer getPoolSize() {
        return poolSize;
    }

    /**
     * Sets pool size.
     *
     * @param poolSize the pool size
     */
    public void setPoolSize(Integer poolSize) {
        this.poolSize = poolSize;
    }

    /**
     * Gets core pool size.
     *
     * @return the core pool size
     */
    public Integer getCorePoolSize() {
        return corePoolSize;
    }

    /**
     * Sets core pool size.
     *
     * @param corePoolSize the core pool size
     */
    public void setCorePoolSize(Integer corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    /**
     * Gets largest pool size.
     *
     * @return the largest pool size
     */
    public Integer getLargestPoolSize() {
        return largestPoolSize;
    }

    /**
     * Sets largest pool size.
     *
     * @param largestPoolSize the largest pool size
     */
    public void setLargestPoolSize(Integer largestPoolSize) {
        this.largestPoolSize = largestPoolSize;
    }

    /**
     * Gets maximum pool size.
     *
     * @return the maximum pool size
     */
    public Integer getMaximumPoolSize() {
        return maximumPoolSize;
    }

    /**
     * Sets maximum pool size.
     *
     * @param maximumPoolSize the maximum pool size
     */
    public void setMaximumPoolSize(Integer maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    /**
     * Gets completed task count.
     *
     * @return the completed task count
     */
    public long getCompletedTaskCount() {
        return completedTaskCount;
    }

    /**
     * Sets completed task count.
     *
     * @param completedTaskCount the completed task count
     */
    public void setCompletedTaskCount(long completedTaskCount) {
        this.completedTaskCount = completedTaskCount;
    }

    /**
     * Gets active.
     *
     * @return the active
     */
    public Integer getActive() {
        return active;
    }

    /**
     * Sets active.
     *
     * @param active the active
     */
    public void setActive(Integer active) {
        this.active = active;
    }

    /**
     * Gets task.
     *
     * @return the task
     */
    public Integer getTask() {
        return task;
    }

    /**
     * Sets task.
     *
     * @param task the task
     */
    public void setTask(Integer task) {
        this.task = task;
    }

    /**
     * Gets keep alive time.
     *
     * @return the keep alive time
     */
    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    /**
     * Sets keep alive time.
     *
     * @param keepAliveTime the keep alive time
     */
    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    /**
     * Gets active percent.
     *
     * @return the active percent
     */
    public String getActivePercent() {
        return activePercent;
    }

    /**
     * Sets active percent.
     *
     * @param activePercent the active percent
     */
    public void setActivePercent(String activePercent) {
        this.activePercent = activePercent;
    }

    /**
     * Gets queue capacity.
     *
     * @return the queue capacity
     */
    public Integer getQueueCapacity() {
        return queueCapacity;
    }

    /**
     * Sets queue capacity.
     *
     * @param queueCapacity the queue capacity
     */
    public void setQueueCapacity(Integer queueCapacity) {
        this.queueCapacity = queueCapacity;
    }
}
