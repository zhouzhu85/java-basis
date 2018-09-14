package com.github.zhouzhu.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName: Java8_Functional_interface
 * @author:zhouzhu
 * @Date: 2018/9/14 17:52
 * @Version: V1.0
 */
public class Java8_Functional_interface {
    public static void main(String[] args){
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println("输出所有数据：");
        eval(list,n->true);
        System.out.println("输出所有偶数：");
        eval(list,n->n%2==0);

        System.out.println("输出大于3的所有数字：");
        eval(list,n -> n>3);
    }
    public static void eval(List<Integer> list, Predicate<Integer> predicate){
        for (Integer n:list){
            if (predicate.test(n)){
                System.out.println(n+" ");
            }
        }
    }
}