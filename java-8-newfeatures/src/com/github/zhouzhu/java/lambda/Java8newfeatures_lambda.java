package com.github.zhouzhu.java.lambda;

/**
 * @ClassName: Java8newfeatures
 * @author:zhouzhu
 * @Date: 2018/9/13 10:45
 * @Version: V1.0
 */
public class Java8newfeatures_lambda {
    //lambda表达式只能引用标记了final的外层局部变量，
    //这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。
    final static String salutation="Hello ";

    public static void main(String args[]){
        Java8newfeatures_lambda tester=new Java8newfeatures_lambda();
        //声明类型
        MathOperation addition=(int a,int b) -> a+b;
        //不用声明类型
        MathOperation subtraction=(a,b) -> a-b;
        //大括号中的返回语句
        MathOperation multiolication=(int a,int b) -> {return a*b;};
        //没有大括号及返回语句
        MathOperation division=(int a,int b) -> a/b;
        System.out.println("10+5="+tester.oprate(10,5,addition));
        System.out.println("10-5="+tester.oprate(10,5,subtraction));
        System.out.println("10*5="+tester.oprate(10,5,multiolication));
        System.out.println("10/5="+tester.oprate(10,5,division));

        //不用括号
        GreetingService greetingService1=message -> System.out.println(salutation+message);
        //用括号
        GreetingService greetingService2=(message) -> System.out.println(salutation+message);
        greetingService1.sayMessage("Runoob");
        greetingService2.sayMessage("Google");
    }

    interface MathOperation{
        int operation(int a,int b);
    }

    interface GreetingService{
        void sayMessage(String message);
    }

    private int oprate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
}
