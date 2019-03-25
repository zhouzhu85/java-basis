package com.zhouzhu.thread;

public class ThreadDemo2 implements Runnable{
    private String name;
    public ThreadDemo2(String name){
        this.name=name;
    }
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println(name+" 运行："+i);
            try {
                Thread.sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class RunnableTest{
    public static void main(String[] args){
        ThreadDemo2 thread1=new ThreadDemo2("a");
        new Thread(thread1).start();
        ThreadDemo2 thread2=new ThreadDemo2("b");
        new Thread(thread2).start();
    }
}
