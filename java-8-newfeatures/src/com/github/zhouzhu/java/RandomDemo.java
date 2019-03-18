package com.github.zhouzhu.java;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomDemo {
    @Test
    public void test1(){
        Random random=new Random();
        IntStream intStream = random.ints(0, 100);
        intStream.limit(10).forEach(System.out::println);
    }
    @Test
    public void test2(){
        Random random=new Random();
        IntStream intStream = random.ints(0, 100);
        List<Integer> randomBetween0And99 = intStream
                .limit(100)
                .boxed()
                .collect(Collectors.toList());
        randomBetween0And99.forEach(System.out::println);
    }
    @Test
    public void test3(){
        Random random=new Random();
        DoubleStream gaussianStream = Stream.generate(random::nextGaussian).mapToDouble(e -> e);
        gaussianStream.forEach(System.out::println);
    }

    /**
     * 生成了一百万个伪随机数
     */
    @Test
    public void test4(){
        Random random=new Random();
        DoubleStream doubleStream = random.doubles(-1.0, 1.0);
        LinkedHashMap<Range, Integer> gaussianRangeCountMap = doubleStream
                .limit(1000000)
                .boxed()
                .map(Ranges::of)
                .collect(Ranges::emptyRangeCountMap, (m, e) -> m.put(e, m.get(e) + 1), Ranges::mergeRangeCountMaps);
        gaussianRangeCountMap.forEach((k,v)->System.out.println(k.from()+"\t"+v));
    }

    /**
     * 生成一百万个高斯伪随机数
     */
    @Test
    public void test5(){
        Random random = new Random();
        DoubleStream gaussianStream = Stream.generate(random::nextGaussian).mapToDouble(e -> e);
        LinkedHashMap<Range, Integer> gaussianRangeCountMap = gaussianStream
                .filter(e -> (e >= -1.0 && e < 1.0))
                .limit(1000000)
                .boxed()
                .map(Ranges::of)
                .collect(Ranges::emptyRangeCountMap, (m, e) -> m.put(e, m.get(e) + 1), Ranges::mergeRangeCountMaps);
        gaussianRangeCountMap.forEach((k,v)->System.out.println(k.from()+"\t"+v));
    }
    public static class Range {
        private final double from;
        private final double to;

        public Range(double from, double to) {
            this.from = from;
            this.to = to;
        }

        public double from() {
            return from;
        }

        public double to() {
            return to;
        }

        @Override
        public String toString() {
            return "From: " + from + " To: " + to;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Range range = (Range) o;

            if (Double.compare(range.from, from) != 0) return false;
            if (Double.compare(range.to, to) != 0) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(from);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(to);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }

    public static class Ranges {
        private static LinkedHashMap<Integer, Range> rangeMap = new LinkedHashMap<>();
        static {
            rangeMap.put(-10, new Range(-1.0, -0.9));
            rangeMap.put(-9,  new Range(-0.9, -0.8));
            rangeMap.put(-8,  new Range(-0.8, -0.7));
            rangeMap.put(-7,  new Range(-0.7, -0.6));
            rangeMap.put(-6,  new Range(-0.6, -0.5));
            rangeMap.put(-5,  new Range(-0.5, -0.4));
            rangeMap.put(-4,  new Range(-0.4, -0.3));
            rangeMap.put(-3,  new Range(-0.3, -0.2));
            rangeMap.put(-2,  new Range(-0.2, -0.1));
            rangeMap.put(-1,  new Range(-0.1, 0.0 ));
            rangeMap.put(0,   new Range(0.0, 0.1  ));
            rangeMap.put(1,   new Range(0.1, 0.2  ));
            rangeMap.put(2,   new Range(0.2, 0.3  ));
            rangeMap.put(3,   new Range(0.3, 0.4  ));
            rangeMap.put(4,   new Range(0.4, 0.5  ));
            rangeMap.put(5,   new Range(0.5, 0.6  ));
            rangeMap.put(6,   new Range(0.6, 0.7  ));
            rangeMap.put(7,   new Range(0.7, 0.8  ));
            rangeMap.put(8,   new Range(0.8, 0.9  ));
            rangeMap.put(9,   new Range(0.9, 1.0  ));
        }

        public static Range of(double d) {
            int key =  (int) Math.floor(d * 10);
            return rangeMap.get(key);
        }

        public static LinkedHashMap<Range, Integer> emptyRangeCountMap() {
            LinkedHashMap<Range, Integer> rangeCountMap = new LinkedHashMap<>();
            for (Range range : rangeMap.values()) {
                rangeCountMap.put(range, 0);
            }
            return rangeCountMap;
        }

        public static void mergeRangeCountMaps(Map<Range, Integer> map1, Map<Range, Integer> map2) {
            for (Range range : rangeMap.values()) {
                map1.put(range, map1.get(range) + map2.get(range));
            }
        }
    }
}
