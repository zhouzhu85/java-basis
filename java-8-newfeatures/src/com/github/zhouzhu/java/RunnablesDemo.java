package com.github.zhouzhu.java;

import org.jooq.lambda.Unchecked;
import org.junit.Test;

import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RunnablesDemo {

    @Test
    public void test1(){
        Thread[] threads={
            new Thread(()->{longOperation();}),
            new Thread(RunnablesDemo::longOperation)
        };
        Arrays.stream(threads).forEach(Thread::start);
//        Arrays.stream(threads).forEach(t->{
//            try {
//                t.join();
//            }catch (InterruptedException e){
//
//            }
//        });
        Arrays.stream(threads).forEach(Unchecked.consumer(
                t->t.join()
        ));
    }
    public static int longOperation(){
        System.out.println("Running on thread #"+Thread.currentThread().getId());
        return 42;
    }

    @Test
    public void test2(){
        ExecutorService service= Executors.newFixedThreadPool(5);
        Future[] answers={
                service.submit(()->longOperation()),
                service.submit(RunnablesDemo::longOperation)
        };
        Arrays.stream(answers).forEach(Unchecked.consumer(f->System.out.println(f.get())));
    }
    @Test
    public void test3(){
        Arrays.stream(new int[]{1,2,3,4,5,6})
                .parallel()
                .max()
                .ifPresent(System.out::println);
    }
    @Test
    public void test4(){
        Runnable task=()->{
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello "+threadName);
        };
        task.run();
        Thread thread=new Thread(task);
        thread.start();
        System.out.println("Done!");
    }

    public static void main(String[] args){
        Runnable runnable=()->{
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo "+name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar "+name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
//        runnable.run();
        Thread thread=new Thread(runnable);
        thread.start();
    }
}
