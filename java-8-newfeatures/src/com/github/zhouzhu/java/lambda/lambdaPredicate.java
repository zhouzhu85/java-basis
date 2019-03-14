package com.github.zhouzhu.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class lambdaPredicate {
    public static void main(String[] args){
        Predicate<String> startsWithJ=(n)->n.startsWith("j");
        Predicate<String> fourLetterLong=(n)->n.length()==4;
        List<String> names = Arrays.asList("jfff", "looo");
        names
                .stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach(n->System.out.println("name,which starts with 'j' and four letter long is: "+n));
    }
}
