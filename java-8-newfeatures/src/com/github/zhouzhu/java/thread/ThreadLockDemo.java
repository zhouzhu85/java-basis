package com.github.zhouzhu.java.thread;

import java.util.concurrent.locks.StampedLock;

public class ThreadLockDemo {
    public static void main(String[] args){
        Point point=new Point();
        point.move(0.1,0.2);
        double v = point.distanceFromOrigin();
        System.out.println(v);
        point.moveIfAtOrigin(0.2,0.5);
    }
}
class Point{
    private double x,y;
    private final StampedLock s1=new StampedLock();
    void move(double deltaX,double deltaY){
        long stamp=s1.writeLock();
        try {
            x+=deltaX;
            y+=deltaY;
        } finally {
            s1.unlockWrite(stamp);
        }
        System.out.println("x="+x+",y="+y);
    }
    //乐观读锁
    double distanceFromOrigin(){
        long stamp = s1.tryOptimisticRead();
        double currentX=x,currenY=y;
        if (!s1.validate(stamp)){
            stamp=s1.readLock();
            try {
                currentX=x;
                currenY=y;
            } finally {
                s1.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX*currenY+currenY*currenY);
    }
    //悲观读锁
    void moveIfAtOrigin(double newX,double newY){
        long stamp = s1.readLock();
        try {
            while (x==0.0 && y==0.0){
                long ws = s1.tryConvertToWriteLock(stamp);
                if (ws!=0L){
                    stamp=ws;
                    x=newX;
                    y=newY;
                    break;
                }else {
                    s1.unlockRead(stamp);
                    stamp=s1.writeLock();
                }
            }
        } finally {
            s1.unlock(stamp);
        }
    }
}
