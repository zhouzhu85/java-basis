package com.zhouzhu.thread;

public class ThreadYield extends Thread{
    private String name;
    public ThreadYield(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i=0;i<50;i++){
            System.out.println(""+this.getName()+"-----"+i);
            if (i==30){
                this.yield();
            }
        }
    }
}
class MainYield{
    public static void main(String[] args){
        ThreadYield thread1=new ThreadYield("a");
        ThreadYield thread2=new ThreadYield("b");
        thread1.start();
        thread2.start();
    }
}
