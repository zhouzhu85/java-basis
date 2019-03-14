package com.github.zhouzhu.java.repeatable;

import java.lang.annotation.*;

/**
 * 重复注解
 */
public class RepeatingAnnotations {
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters{
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter{
        String value();
    }
    @Filter("filter1")
    @Filter("filter2")
    public interface Filterable{

    }
    public static void main(String[] args){
        for (Filter filter:Filterable.class.getAnnotationsByType(Filter.class)){
            System.out.println(filter.value());
        }
    }
}
