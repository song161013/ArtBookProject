/**
 * @author: songfei
 * @Title:ThreadPool.java
 * @Description: 
 * @DATE: 2017-7-24下午4:45:55
 * 
 */
package com.sf.art._11thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool extends ThreadPoolExecutor {

    /**
     * @param corePoolSize
     * @param maximumPoolSize
     * @param keepAliveTime
     * @param unit
     * @param workQueue
     */
    public ThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
	    BlockingQueue<Runnable> workQueue) {
	super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

}
