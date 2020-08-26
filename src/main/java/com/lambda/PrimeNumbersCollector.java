package com.lambda;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

/**
 * @author WhomHim
 * @description 自定义收集器
 * @date Create in 2020-8-26 23:17:56
 */
public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

    /**
     * 作用：创建结果容器
     */
    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<Boolean, List<Integer>>() {{
            put(true, new ArrayList<>());
            put(false, new ArrayList<>());
        }};
    }

    /**
     * 作用：将元素添加到结果容器
     */
    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            acc.get(isPrime(acc.get(true)
                    , candidate)
            ).add(candidate);
        };
    }

    /**
     * 对结果容器进行转换
     */
    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (Map<Boolean, List<Integer>> map1,
                Map<Boolean, List<Integer>> map2) -> {

            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    /**
     * 作用:当为并行流时，合并两个或多个结果容器
     */
    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    /**
     * 作用：返回一个不可变的 Characteristics 集合
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
    }

    /**
     * 行为参数化方法，
     */
    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }

    /**
     * 主要判断逻辑（）判断是否是质数
     */
    public static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, i -> i <= candidateRoot).stream().noneMatch(p -> candidate % p == 0);
    }
}
