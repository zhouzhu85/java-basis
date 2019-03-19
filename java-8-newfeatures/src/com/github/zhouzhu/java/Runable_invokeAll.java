package com.github.zhouzhu.java;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runable_invokeAll {
    public static void main(String[] args){
        ExecutorService executor= Executors.newWorkStealingPool();
        List<Callable<String>> callables=Arrays.asList(
                ()-> "task1",
                ()->"task2",
                ()->"task3"
        );
        try {
            executor.invokeAll(callables)
                    .stream()
                    .map(future->{
                        try {
                            return future.get();
                        } catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
