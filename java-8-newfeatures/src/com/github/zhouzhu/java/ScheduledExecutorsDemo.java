package com.github.zhouzhu.java;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsDemo {
    public static void main(String[] args){
        try {
            ScheduledExecutorService executor= Executors.newScheduledThreadPool(1);
            Runnable task=()->System.out.println("Schedule: "+System.nanoTime());
            ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);
            TimeUnit.MICROSECONDS.sleep(1337);
            long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
            System.out.printf("Remaining Delay: %sms",remainingDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
