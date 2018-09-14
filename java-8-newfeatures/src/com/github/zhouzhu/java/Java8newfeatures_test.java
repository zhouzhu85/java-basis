package com.github.zhouzhu.java;

import java.util.*;

/**
 * @ClassName: Java8newfeatures
 * @author:zhouzhu
 * @Date: 2018/9/13 10:45
 * @Version: V1.0
 */
public class Java8newfeatures_test {
    public static void main(String args[]){
        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");
        Java8newfeatures_test java8newfeatures2=new Java8newfeatures_test();
        System.out.println("java7用法");
        java8newfeatures2.sortUsingJava7(names1);
        System.out.println(names1);

        System.out.println("java8用法");
        java8newfeatures2.sortUsingJava8(names2);
        System.out.println(names2);

    }
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    private void sortUsingJava8(List<String> names){
        Collections.sort(names,(s1,s2) -> s1.compareTo(s2));
    }

}
