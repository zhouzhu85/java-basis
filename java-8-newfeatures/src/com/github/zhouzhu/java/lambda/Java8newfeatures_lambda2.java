package com.github.zhouzhu.java.lambda;

/**
 * @ClassName: Java8newfeatures
 * @author:zhouzhu
 * @Date: 2018/9/13 10:45
 * @Version: V1.0
 */
public class Java8newfeatures_lambda2 {

    public static void main(String args[]){
        final int num=1;
        Converter<Integer,String> s=(param) -> System.out.println(String.valueOf(param+num));
        s.convert(2);
    }
    public interface Converter<T1,T2>{
        void convert(int i);
    }
}
