package com.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;


/**
 * @author WhomHim
 * @description
 * @date Create in 2020-8-26 23:31:21
 */
@SuppressWarnings("UnusedReturnValue")
public class Collector2 {

    public static void main(String[] arg) {
        long fastest = Long.MAX_VALUE;
        int i = 0;
        while (i < 10) {
            long start = System.nanoTime();
            partitionPaimesWithCustomCollector(1000000);
            long duration = (System.nanoTime() - start) / 1000000;
            if (duration < fastest) fastest = duration;
            i++;
        }
        System.out.println("CustomCollector Fastest execution done in " + fastest + " msecs");
    }


    /**
     * 自定义收集器调用
     */
    public static Map<Boolean, List<Integer>> partitionPaimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(
                /* 创建结果容器 */
                () -> new HashMap<Boolean, List<Integer>>() {{
                    put(true, new ArrayList<>());
                    put(false, new ArrayList<>());
                }},
                /* 将元素添加到结果容器 */
                (acc, candidate) -> {
                    acc.get(isPrime(acc.get(true)
                            , candidate)
                    ).add(candidate);
                },
                /* 对结果容器进行转换 */
                (map1, map2) -> {
                    map1.get(true).addAll(map2.get(true));
                    map1.get(false).addAll(map2.get(false));
                });
    }

    /**
     * 行为参数化方法
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
     * 业务逻辑
     */
    public static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return takeWhile(primes, i -> i <= candidateRoot).stream().noneMatch(p -> candidate % p == 0);
    }
}
