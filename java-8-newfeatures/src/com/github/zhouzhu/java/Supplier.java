package com.github.zhouzhu.java;

@FunctionalInterface
public interface Supplier<T> {
    T get();
}

class Car{
    public static Car create(final Supplier<Car> supplier){
        return supplier.get();
    }
    public static void collide(final Car car){
        System.out.println("Collided "+car.toString());
    }

    public void follow(final Car another){
        System.out.println("Following the "+another.toString());
    }

    public void repair(){
        System.out.println("Repaired "+this.toString());
    }
}