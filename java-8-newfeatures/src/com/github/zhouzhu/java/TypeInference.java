package com.github.zhouzhu.java;

/**
 * 类型推测机制
 */
public class TypeInference {
    public static void main(String[] args){
        final Value<Integer> value=new Value<>();
        Integer orDefault = value.getOrDefault(555, Value.defaultValue());
        System.out.println(orDefault.intValue());
    }
}
