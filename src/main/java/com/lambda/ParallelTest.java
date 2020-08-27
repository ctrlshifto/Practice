package com.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author WhomHim
 * @description 并行流 demo
 * <p>
 * 影响性能的五要素是：数据大小、源数据结构、值是否装箱、可用的 CPU 核数量，以及处理每个元素所花的时间。
 * </p>
 * @date Create in 2020/8/27 18:51
 */
public class ParallelTest {
    /**
     * 串行reduce初始值为任意值并不会有问题
     */
    public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream().reduce(5, (acc, x) -> x * acc);
    }

    @Test
    public void test611() {
        List<Integer> linkedListOfNumbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("multiplyThrough: " + multiplyThrough(linkedListOfNumbers));
        System.out.println("serialMultiplyThrough: " + serialMultiplyThrough(linkedListOfNumbers));
    }

    /**
     * 并行reduce初始值必须为特定值，所以为了保持结果不变，把最终结果 * 5
     */
    public static int serialMultiplyThrough(List<Integer> linkedListOfNumbers) {
        return 5 * linkedListOfNumbers.parallelStream().reduce(1, (acc, x) -> x * acc);
    }

    /**
     * 3.例6-12中的代码计算列表中数字的平方和。尝试改进代码性能，但不得牺牲代码质量。只需要一些简单的改动即可。
     */
    public int slowSumOfSquares(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.parallelStream()
                .map(x -> x * x)
                .reduce(0, Integer::sum);
    }

    @Test
    public void test612() {
        List<Integer> linkedListOfNumbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("slowSumOfSquares: " + slowSumOfSquares(linkedListOfNumbers));
        System.out.println("fastSumOfSquares: " + fastSumOfSquares(linkedListOfNumbers));
        System.out.println("serialFastSumOfSquares: " + serialFastSumOfSquares(linkedListOfNumbers));
    }

    /**
     * 高效并行计算
     */
    public int fastSumOfSquares(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.parallelStream().mapToInt(x -> x * x).sum();
    }

    /**
     * 高效串行计算
     */
    public int serialFastSumOfSquares(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream().mapToInt(x -> x * x).sum();
    }
}
