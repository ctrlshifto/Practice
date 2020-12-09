package com.vavr;

import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Function3;
import org.junit.Test;

/**
 * @author WhomHim
 * @date Create in 2020/12/9 16:45
 */
public class FunctionTest {

    @Test
    public void partialApplication() {
        //sum 函数通过部分应用，第一个参数被固定为 2，并产生新的 add2 函数。
        Function2<Integer, Integer, Integer> sum = Integer::sum;
        Function1<Integer, Integer> add2 = sum.apply(2);
        System.out.println(add2.apply(1));
    }

    /**
     * 柯里化是把接受多个参数的函数变换成接受一个单一参数（最初函数的第一个参数）的函数，
     * 并且返回接受余下的参数而且返回结果的新函数的技术。
     */
    @Test
    public void currying() {
        Function3<Integer, Integer, Integer, Integer> sum = (a, b, c) -> a + b + c;
        final Function1<Integer, Function1<Integer, Integer>> add2 = sum.curried().apply(2);

        // = 9
        Integer i = add2.apply(4).apply(3);
        System.out.println(i);
    }

    private static void functions() {
        //使用 andThen
        Function1<Integer, Integer> plusOne = a -> a + 1;
        Function1<Integer, Integer> multiplyByTwo = a -> a * 2;
        Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.andThen(multiplyByTwo);
        System.out.println(add1AndMultiplyBy2.apply(2).intValue());

        //使用 compose
        Function1<Integer, Integer> add1AndMultiplyBy2WithCompose = multiplyByTwo.compose(plusOne);
        System.out.println(add1AndMultiplyBy2WithCompose.apply(2).intValue());
    }
}
