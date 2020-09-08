package com.vavr;

import io.vavr.Tuple;
import io.vavr.*;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.junit.Test;

import java.util.function.Predicate;

import static io.vavr.API.*;
import static io.vavr.Predicates.isIn;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020/8/12 16:40
 */
public class VavrSimpleTest {

    @Test
    public void tuples() {
        System.out.println("------------> Tuples");
        // (Java, 8)
        Tuple2<String, Integer> java8 = Tuple.of("Java", 8);

        // "Java"
        String s = java8._1;

        // 8
        Integer i = java8._2;
        System.out.println(java8);

        // (vavr, 1)
        Tuple2<String, Integer> that = java8.map(
                str -> s.substring(2) + "vr",
                j -> j / 8
        );
        System.out.println(that);

        // "vavr 1"
        String apply = java8.apply(
                (s2, i2) -> s.substring(2) + "vr " + i / 8
        );
        System.out.println(apply);
        System.out.println("------------> Tuples");

        System.out.println("--------> 元组使用场景:函数返回多个参数");
        Tuple3<String, Integer, Integer> test = Tuple.of("test", 1, 2);
        System.out.println("--------> 将 Tuple1 return：" + test);
        System.out.println("--------> 元组使用场景:函数返回多个参数");
    }


    private static void functions() {
        Function2<Integer, Integer, Integer> sum = Integer::sum;
        System.out.println(sum);
        //使用 andThen
        Function1<Integer, Integer> plusOne = a -> a + 1;
        Function1<Integer, Integer> multiplyByTwo = a -> a * 2;
        Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.andThen(multiplyByTwo);
        System.out.println(add1AndMultiplyBy2.apply(2).intValue());

        //使用 compose
        Function1<Integer, Integer> add1AndMultiplyBy2WithCompose = multiplyByTwo.compose(plusOne);
        System.out.println(add1AndMultiplyBy2WithCompose.apply(2).intValue());
    }

    @Test
    public void list() {
        // vavr 的 List 是不可变的
        List<Integer> of = List.of(1, 2, 3, 4);
        List<Integer> prepend = of.prepend(1).prepend(3);
        System.out.println(of);
        System.out.println(prepend);
    }

    @SuppressWarnings({"divzero", "NumericOverflow"})
    @Test
    public void tryDemo() {
        Try.of(() -> 1 / 0)
                .andThen(r -> System.out.println("and then " + r))
                .onFailure(error -> System.out.println("failure" + error.getMessage()))
                .andFinally(() -> System.out.println("finally"));
    }

    @Test
    public void tryDemo2() {
        String str = "hello word!";
        Try.of(() -> str)
                .filter(s -> !"hello word!".equals(s))
                .onFailure(System.out::println)
                .getOrElse("s2");
    }

    private static String testTryWithRecover(Exception e) {
        return (String) Try.of(() -> {
            throw e;
        })
                .recoverWith(NullPointerException.class, Try.of(() -> "NPE"))
                .recoverWith(IllegalStateException.class, Try.of(() -> "IllegalState"))
                .recoverWith(RuntimeException.class, Try.of(() -> "Unknown"))
                .get();

    }

    @Test
    public void testTryMap() {
        String res = Try.of(() -> "hello world")
                .map(String::toUpperCase)
                .toOption()
                .getOrElse(() -> "default");
        System.out.println(res);
    }

    public static String bmiFormat(double height, double weight) {
        double bmi = weight / (height * height);
        return Match(bmi).of(
                // else if (bmi < 18.5)
                Case($(v -> v < 18.5), () -> "有些许晃荡！"),
                // else if (bmi < 25)
                Case($(v -> v < 25), () -> "继续加油哦！"),
                // else if (bmi < 30)
                Case($(v -> v < 30), () -> "你是真的稳！"),
                // else
                Case($(), () -> "难受！")
        );
    }

    @Test
    public void matchDemo() {
        String arg = "-v";
        Object of = Match(arg).of(
                Case($(Predicate.isEqual("-1")), "1"),
                Case($(Predicate.isEqual("-v")), "2"),
                Case($(Predicate.isEqual("-v1")), "3")
        );
        System.out.println(of);
    }

    @Test
    public void matchDemo2() {
        String arg = "asd";
        Object of = Match(arg).of(
                Case($(isIn("-h", "--help")), run(this::hello)),
                Case($(isIn("-v", "--version")), "2"),
                Case($(), o -> run(() -> {
                    throw new IllegalArgumentException(arg);
                }))
        );
        System.out.println(of);
    }

    private void hello() {
        System.out.println("hello world!");
    }

    public static void main(String[] args) {
        functions();
        String testTryWithRecover = testTryWithRecover(new IllegalStateException());
        System.out.println(testTryWithRecover);
        String bmiFormat = bmiFormat(175, 60);
        System.out.println(bmiFormat);
    }
}
