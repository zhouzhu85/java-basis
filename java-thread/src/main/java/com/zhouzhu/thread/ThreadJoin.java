package com.zhouzhu.thread;

public class ThreadJoin  extends Thread{
    private String name;
    public ThreadJoin(String name){
        super(name);
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 线程运行开始");
        for (int i=0;i<5;i++){
            System.out.println("子线程"+name+"运行："+i);
            try {
                sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"线程运行结束");
    }
}
class Main{
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName()+"主线程运行开始");
        ThreadJoin thread1=new ThreadJoin("a");
        ThreadJoin thread2=new ThreadJoin("b");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"主线程运行结束");
    }
}
