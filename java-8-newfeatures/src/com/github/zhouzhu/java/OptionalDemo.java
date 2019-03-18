package com.github.zhouzhu.java;

import com.sun.xml.internal.fastinfoset.util.ValueArrayResourceException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
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

    @Test
    public void testOf(){
//        Optional<String> name = Optional.of("ff");
        //传空值报NullPointerException
        Optional<String> name = Optional.of(null);
        System.out.println(name);

    }
    @Test
    public void testOfNullable(){
        Optional.ofNullable(null);
    }
    @Test
    public void testIsPresent(){
        Optional name1=Optional.ofNullable("666");
        if (name1.isPresent()){
            System.out.println("name1的值："+name1.get());
        }
        Optional name2=Optional.ofNullable(null);
        if (name2.isPresent()){
            System.out.println("name2的值："+name2.get());
        }
    }
    @Test
    public void testIfPresent(){
        Optional<String> name=Optional.ofNullable("555");
        name.ifPresent((value)->{System.out.println("The length of the vlaue is :"+value.length());});
        Optional<String> name1=Optional.ofNullable(null);
        name1.ifPresent((value)->{System.out.println("The length of the vlaue1 is :"+value.length());});
    }
    @Test
    public void testOrElse(){
        Optional empty=Optional.ofNullable(null);
        System.out.println(empty.orElse("没值"));
        Optional empty1=Optional.ofNullable("6666");
        System.out.println(empty.orElse("没值"));
    }
    @Test
    public void testOrElseGet(){
        Optional empty=Optional.ofNullable(null);
        System.out.println(empty.orElseGet(()->"没值"));
        Optional empty1=Optional.ofNullable("555");
        System.out.println(empty1.orElseGet(()->"没值"));
    }
    @Test
    public void testOrElseThrow(){
        Optional empty=Optional.ofNullable(null);
        try {
            empty.orElseThrow(ValueAbsentException::new);
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
        Optional empty1=Optional.ofNullable("666");
        try {
            empty1.orElseThrow(ValueArrayResourceException::new);
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }
    class ValueAbsentException extends Throwable{
        public ValueAbsentException(){
            super();
        }
        public ValueAbsentException(String msg){
            super(msg);
        }

        @Override
        public String getMessage() {
            return "No value present in the Optional instance";
        }
    }

    @Test
    public void testMap(){
        Optional<String> s = Optional.ofNullable("kkk");
        Optional<String> s1 = s.map((value) -> value.toUpperCase());
        System.out.println(s1.orElse("no value found"));

    }

    /**
     * 如果有值，为其执行mapping函数返回Optional类型返回值，否则返回空Optional。flatMap与map（Funtion）方法类似，区别在于flatMap中的mapper返回值必须是Optional。调用结束时，flatMap不会对结果用Optional封装。
     * flatMap方法与map方法类似，区别在于mapping函数的返回值不同。map方法的mapping函数返回值可以是任何类型T，而flatMap方法的mapping函数必须是Optional。
     */
    @Test
    public void testflatMap(){
        Optional<String> name = Optional.ofNullable("kkk");
        Optional<String> upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("no value found"));
    }
    @Test
    public void testFilter(){
        Optional<String> name = Optional.ofNullable("kkkkkkk");
        Optional<String> longName = name.filter(value -> value.length() > 6);
        System.out.println(longName.orElse("the name is less than 6 characters"));
        Optional<String> name1 = Optional.ofNullable("kkkk");
        Optional<String> shortName = name1.filter(value -> value.length() > 6);
        System.out.println(shortName.orElse("the name is less than 6 characters"));
    }
}
