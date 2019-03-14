package com.github.zhouzhu.java;

/**
 * 类型推测机制
 * @param <T>
 */
public class Value<T> {
    public static <T> T defaultValue(){
        return null;
    }
    public T getOrDefault(T value,T defaultValue){
        return (value!=null)? value : defaultValue;
    }
}
