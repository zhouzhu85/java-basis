package com.github.zhouzhu.java.lambda;

import jdk.nashorn.internal.objects.annotations.Function;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambda_stream {

    @Test
    public  void test(){
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str)->false);
        //假设一个业务场景：对于20元以上的商品，进行9折处理，最后得到这些商品的折后价格。
       List<BigDecimal> prices=Arrays.asList(BigDecimal.valueOf(40),BigDecimal.valueOf(60),BigDecimal.valueOf(90));
       prices
                .stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .forEach(n->System.out.println(n));
//       System.out.println(reduce);
    }
    public static void filter(List names, Predicate condition){
        names.stream().filter((name)->(condition.test(name))).forEach(name->System.out.println(name+" "));
    }

    /**
     * 每个字符长度大于2
     */
    @Test
    public void test1(){
        List<String> strings = Arrays.asList("abc","dbc","ddd","df");
        List<String> collect = strings
                .stream()
                .filter(x -> x.length() > 2)
                .collect(Collectors.toList());
        System.out.printf("Original list: %s,filtered list: %s %n",strings,collect);
    }

    /**
     * 字母转换成大写
     */
    @Test
    public void test3(){
        List<String> stringList = Arrays.asList("aaa", "fff", "Ddds");
        String collect = stringList
                .stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.joining(","));
        System.out.printf(collect);
    }

    /**
     * stream distinct()去重
     */
    @Test
    public void test4(){
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6,6);
        List<Integer> collect = integerList
                .stream()
                .map(i -> i * i)
                .distinct()
                .collect(Collectors.toList());
        System.out.printf("Original list : %s,Square without duplicates : %s %n",integerList,collect);
    }
    @Test
    public void test5(){
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes
                .stream()
                .mapToInt(x -> x)
                .summaryStatistics();
        System.out.println("最大值："+stats.getMax());
        System.out.println("最小值："+stats.getMin());
        System.out.println("总和："+stats.getSum());
        System.out.println("平均值："+stats.getAverage());
    }
    @Test
    public void test6(){
        System.out.println(parallelStreamMaxInteger());
        System.out.println(lambdaMaxInteger());
        System.out.println(forEachLambdaMaxInteger());
        System.out.println(streatMaxInteger());
    }
    public int parallelStreamMaxInteger() {
        List<Integer> integers = Arrays.asList(56, 2, 444, 222, 11111);
        Optional<Integer> max = integers.parallelStream().reduce(Integer::max);
        return max.get();
    }
    public int streatMaxInteger(){
        List<Integer> integers = Arrays.asList(56, 2, 444, 222, 11111);
        Optional<Integer> max = integers.stream().reduce(Integer::max);
        return max.get();

    }
    public int lambdaMaxInteger(){
        List<Integer> integers = Arrays.asList(56, 2, 444, 222, 11111);
        return integers.stream().reduce(Integer.MIN_VALUE,(a,b)->Integer.max(a,b));
    }
    public int forEachLambdaMaxInteger(){
        List<Integer> integers = Arrays.asList(56, 2, 444, 222, 11111);
        final Wrapper wrapper=new Wrapper();
        wrapper.inner=Integer.MIN_VALUE;
        integers.forEach(i->helper(i,wrapper));
        return wrapper.inner.intValue();
    }
    static class Wrapper{
        public Integer inner;
    }
    private int helper(int i,Wrapper wrapper){
        wrapper.inner=Math.max(i,wrapper.inner);
        return wrapper.inner;
    }
}
