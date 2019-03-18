package com.github.zhouzhu.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;


public class Lambda_comparator {
    @Test
    public void givenPreLambda_whenSortingEntitiesByName_thenCorrectlySorted(){
        List<Human> humans = Arrays.asList(new Human("Aarah", 10), new Human("Jack", 12));
//        Collections.sort(humans, new Comparator<Human>() {
//            @Override
//            public int compare(Human o1, Human o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
        humans.sort((h1,h2)->h1.getName().compareTo(h2.getName()));
        //Assert.assertThat(humans.get(0),equalTo(new Human("Jack",12)));
        humans.forEach(n->System.out.println(n.getName()));
    }

    /**
     * 使用静态方法的引用来排序
     */
    @Test
    public void givenMethodDefinition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted(){
        List<Human> humans = Arrays.asList(new Human("Aarah", 10), new Human("Jack", 12));
        humans.sort(Human::compareByNameThenAge);
        humans.forEach(n->System.out.println(n.getName()));
    }

    /**
     * 提取Comparator进行排序
     */
    @Test
    public void givenInstanceMethod_whenSortingEntitiesByNameThenAge_thenCorrectlySorted(){
        List<Human> humans = Arrays.asList(new Human("zarah", 10), new Human("Jack", 12),new Human("Barah", 10));
        Collections.sort(humans,Comparator.comparing(Human::getName));
        humans.forEach(n->System.out.println(n.getName()));
    }

    /**
     * 反转排序
     */
    @Test
    public void whenSortingEntitiesByNameReversed_thenCorrectlySorted(){
        List<Human> humans = Arrays.asList(new Human("zarah", 10), new Human("Jack", 12),new Human("Barah", 10));
        Comparator<Human> comparator=(h1,h2)->h1.getName().compareTo(h2.getName());
        humans.sort(comparator.reversed());
        humans.forEach(n->System.out.println(n.getName()));

    }

    /**
     * 多条件排序
     */
    @Test
    public void whenSortingEntitiesByNameThenAge_thenCorrectlySorted(){
        List<Human> humans = Arrays.asList(new Human("zarah", 10), new Human("Jack", 12),new Human("zarah", 10));
        humans.sort((h1,h2)->{
            if (h1.getName().equals(h2.getName())){
                return h1.getAge()-h2.getAge();
            }else {
                return h1.getName().compareTo(h2.getName());
            }
        });
        humans.forEach(n->System.out.println(n.getName()));

    }

    /**
     * 多条件组合排序
     */
    @Test
    public void givenComposition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted(){
        List<Human> humans = Arrays.asList(new Human("zarah", 18), new Human("Jack", 12),new Human("Barah", 16));
        humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
        humans.forEach(n->System.out.println(n.getName()));
    }
}
