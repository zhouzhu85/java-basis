package com.github.zhouzhu.java;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Runnable_invokeAny {
    public static void main(String[] args){
        ExecutorService executor= Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                callable("task1", 1),
                callable("task2", 2),
                callable("task3", 3)
        );
        String result = null;
        try {
            result = executor.invokeAny(callables);
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
     public static Callable<String> callable(String result,long sleepSpeconds){
        return ()->{
            TimeUnit.SECONDS.sleep(sleepSpeconds);
            return result;
        };
    }
}
