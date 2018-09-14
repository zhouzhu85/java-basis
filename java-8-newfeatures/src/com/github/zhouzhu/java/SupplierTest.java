package com.github.zhouzhu.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: SupplierTest
 * @author:zhouzhu
 * @Date: 2018/9/14 16:50
 * @Version: V1.0
 */
public class SupplierTest {
    public static void main(String[] args){
        final Car car=Car.create(Car::new);
        final List<Car> cars= Arrays.asList(car);
        cars.forEach(Car::collide);
        cars.forEach(Car::repair);
        final Car police=Car.create(Car::new);
        cars.forEach(police::follow);

        List names=new ArrayList();
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.forEach(System.out::println);
    }
}
