package com.github.zhouzhu.java;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *这个例子调度了一个任务，并在一次执行的结束和下一次执行的开始之间设置了一个1分钟的固定延迟。初始化延迟为0，任务执行时间为0。所以我们分别在0s,3s,6s,9s等间隔处结束一次执行
 */
public class ScheduledExecutorsDemo3 {
    public static void main(String[] args){
        ScheduledExecutorService executor=Executors.newScheduledThreadPool(1);
        Runnable task=()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: "+System.nanoTime());
            } catch (InterruptedException e) {
                System.out.println("task interrupted");
            }
        };
        executor.scheduleWithFixedDelay(task,0,1,TimeUnit.SECONDS);
    }
}
