package com.github.zhouzhu.java;

import java.util.concurrent.*;

public class Runnable_Callables {
    public static void main(String[] args){
        Callable<Integer> task=()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted",e);
            }
        };
        try {
            ExecutorService executor=Executors.newFixedThreadPool(1);
            Future<Integer> future = executor.submit(task);
            System.out.println("future done?"+future.isDone());
            Integer result = future.get();
            System.out.println("future done?"+future.isDone());
            System.out.println("result: "+result);
            executor.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
