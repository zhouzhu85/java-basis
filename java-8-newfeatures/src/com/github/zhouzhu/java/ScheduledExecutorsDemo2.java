package com.github.zhouzhu.java;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 为了调度任务持续的执行，executors 提供了两个方法scheduleAtFixedRate()和scheduleWithFixedDelay()。第一个方法用来以固定频率来执行一个任务，比如，下面这个示例中，每分钟一次
 */
public class ScheduledExecutorsDemo2 {
    public static void main(String[] args){
        ScheduledExecutorService executor=Executors.newScheduledThreadPool(1);
        Runnable task=()->System.out.println("Scheduling: "+System.nanoTime());
        int initialDelay=0;
        int period=1;
        executor.scheduleAtFixedRate(task,initialDelay,period,TimeUnit.SECONDS);
    }
}
