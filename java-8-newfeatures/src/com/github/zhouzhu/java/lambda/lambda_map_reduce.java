package com.github.zhouzhu.java.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class lambda_map_reduce {
    /**
     * 为每个订单加上12%的税
     */
    @Test
    public void test(){
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        Double bill = costBeforeTax
                .stream()
                .map(cost -> cost + 0.12 * cost)
                .reduce((sum, cost) -> sum + cost)
                .get();
        System.out.println("total: "+bill);
    }

}
