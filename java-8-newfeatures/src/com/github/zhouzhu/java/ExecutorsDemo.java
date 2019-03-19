package com.github.zhouzhu.java;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsDemo {
    public static void main(String[] args){
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        executorService.submit(()->{
            String name = Thread.currentThread().getName();
            System.out.println("Hello "+name);
        });
        try {
            System.out.println("attempt to shutdown executor");
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
//            e.printStackTrace();
            System.err.println("tasks interrupted");
        }finally {
            if (!executorService.isTerminated()){
                System.out.println("cancel non-finished tasks");
            }
            executorService.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}
