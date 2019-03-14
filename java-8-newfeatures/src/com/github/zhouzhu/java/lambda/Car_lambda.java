package com.github.zhouzhu.java.lambda;

import org.junit.Test;

/**
 * 方法引用
 */
import java.util.Arrays;
import java.util.List;

public class Car_lambda {
    @Test
    public void test1(){
        final Car car=Car.create(Car::new);
        List<Car> cars = Arrays.asList(car);

        cars.forEach(Car::collide);
        cars.forEach(Car::repair);
        final Car police=Car.create(Car::new);
        cars.forEach(police::follow);
    }
}
