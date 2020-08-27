package com.lambda;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020-8-26 23:20:31
 */
@SuppressWarnings("UnusedReturnValue")
public class PrimeNumbersCollectorTest {
    public static void main(String[] arg) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            partitionPrimes(1000000);
            long duration = (System.nanoTime() - start) / 1000000;
            if (duration < fastest) fastest = duration;
        }
        System.out.println("Fastest execution done in " + fastest + " msecs");

        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            partitionPaimesWithCustomCollector(1000000);
            long duration = (System.nanoTime() - start) / 1000000;
            if (duration < fastest) fastest = duration;
        }
        System.out.println("CustomCollector Fastest execution done in " + fastest + " msecs");
    }


    /**
     * 自定义收集器调用
     */
    public static Map<Boolean, List<Integer>> partitionPaimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
    }


    /**
     * 采用系统分区函数
     *
     * @param n
     */
    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).
                boxed().
                collect(partitioningBy(candidate -> isPrime(candidate)));
    }


    /**
     * 判断是否为质数
     */
    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot).boxed().noneMatch(i -> candidate % i == 0);
    }

}
