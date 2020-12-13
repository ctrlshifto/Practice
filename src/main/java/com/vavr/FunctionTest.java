package com.vavr;

import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Function3;
import io.vavr.control.Option;
import org.junit.Test;

import java.util.function.Function;

/**
 * @author WhomHim
 * @date Create in 2020/12/9 16:45
 */
public class FunctionTest {

    /**
     * Partial application - 偏函数应用
     */
    @Test
    public void partialApplication() {
        //sum 函数通过部分应用，第一个参数被固定为 2，并产生新的 add2 函数。
        Function2<Integer, Integer, Integer> sum = Integer::sum;
        Function1<Integer, Integer> add2 = sum.apply(2);
        System.out.println(add2.apply(1));
    }

    /**
     * currying - 柯里化是把接受多个参数的函数变换成接受一个单一参数（最初函数的第一个参数）的函数，
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

    /**
     * Composition - 组合
     */
    @Test
    public   void composition() {
        //使用 andThen
        Function1<Integer, Integer> plusOne = a -> a + 1;
        Function1<Integer, Integer> multiplyByTwo = a -> a * 2;
        Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.andThen(multiplyByTwo);
        System.out.println(add1AndMultiplyBy2.apply(2).intValue());

        //使用 compose
        Function1<Integer, Integer> add1AndMultiplyBy2WithCompose = multiplyByTwo.compose(plusOne);
        System.out.println(add1AndMultiplyBy2WithCompose.apply(2).intValue());
    }

    Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;

    @SuppressWarnings("Convert2MethodRef")
    Function2<Integer, Integer, Integer> add2 = (x, y) -> x + y;

    @Test
    public void add() {
        Integer apply = add.apply(1).apply(2);
        Integer apply1 = add2.apply(1, 2);
        System.out.println(apply);
        System.out.println(apply1);
    }

    /**
     * Lifting - 提升是针对部分函数（partial function）的操作，如果一个函数 f(x) 的定义域是 x，另一个函数 g(y) 跟 f(x) 定义相同，
     * 只是定义域 y 是 x 的子集，就说 f(x) 是全函数（total function），g(y) 是部分函数。函数的提升会返回当前函数的全函数，
     * 返回类型为 Option
     */
    @Test
    public void lifting() {
        // 定义一个部分函数
        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;
        //利用 lift 将 divide 提升为可以接收所有输入的全函数：
        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);
        // = None
        Option<Integer> i1 = safeDivide.apply(1, 0);
        System.out.println(i1);
        // = Some(2)
        Option<Integer> i2 = safeDivide.apply(4, 2);
        System.out.println(i2);

        divide.apply(1,0);
    }
}
