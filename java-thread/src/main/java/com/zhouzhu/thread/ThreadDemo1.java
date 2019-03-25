package com.zhouzhu.thread;

public class ThreadDemo1 extends Thread{
    private String name;
    public ThreadDemo1(String name){
        this.name=name;
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
          System.out.println(name+"运行 ："+i);
            try {
                sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class ThreadTest{
    public static void main(String[] args){
        ThreadDemo1 a = new ThreadDemo1("a");
        a.start();
//        a.start(); 重复调用会报异常illegalThreadStateException
        new ThreadDemo1("b").start();
        new ThreadDemo1("c").start();
    }
}
