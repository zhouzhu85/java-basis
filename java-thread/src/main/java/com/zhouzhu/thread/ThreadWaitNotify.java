package com.zhouzhu.thread;

/**
 * 建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，要求线程同时运行，交替打印10次ABC
 */
public class ThreadWaitNotify implements Runnable{
    private String name;
    private Object prev;
    private Object self;

    public ThreadWaitNotify(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    public void run() {
        int count=10;
        while (count>0){
            synchronized (prev){
                synchronized (self){
                    System.out.println(name);
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Object a=new Object();
        Object b=new Object();
        Object c=new Object();
        ThreadWaitNotify pa = new ThreadWaitNotify("A", c, a);
        ThreadWaitNotify pb = new ThreadWaitNotify("B", a, b);
        ThreadWaitNotify pc = new ThreadWaitNotify("C", b, c);
        new Thread(pa).start();
        Thread.sleep(100);
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);

    }
}
