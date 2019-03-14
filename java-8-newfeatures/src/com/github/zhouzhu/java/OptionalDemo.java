package com.github.zhouzhu.java;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类使用
 */
public class OptionalDemo {
    @Test
    public void test(){
        Optional<String> fullName = Optional.ofNullable(null);
        System.out.println("full name is set?"+fullName.isPresent());
        System.out.println("full name: "+fullName.orElseGet(() -> "[none]"));
        System.out.println(fullName.map(s -> "hey "+s+ "!").orElse("Hey Stranger"));
    }

    @Test
    public void test2(){
        Optional<String> fullName = Optional.of("tom");
        System.out.println("full name is set?"+fullName.isPresent());
        System.out.println("full name: "+fullName.orElseGet(() -> "[none]"));
        System.out.println(fullName.map(s -> "hey "+s+ "!").orElse("Hey Stranger"));
    }
}
