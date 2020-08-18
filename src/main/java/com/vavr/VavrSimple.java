package com.vavr;

import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.junit.Test;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020/8/12 16:40
 */
public class VavrSimple {

    private static void Tuples() {
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
    }


    private static void Functions() {
        Function2<Integer, Integer, Integer> sum = Integer::sum;
        //使用 andThen
        Function1<Integer, Integer> plusOne = a -> a + 1;
        Function1<Integer, Integer> multiplyByTwo = a -> a * 2;
        Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.andThen(multiplyByTwo);
        System.out.println(add1AndMultiplyBy2.apply(2).intValue());

        //使用 compose
        Function1<Integer, Integer> add1AndMultiplyBy2WithCompose = multiplyByTwo.compose(plusOne);
        System.out.println(add1AndMultiplyBy2WithCompose.apply(2).intValue());
    }

    private static void List() {
        List<Integer> of = List.of(1, 2, 3, 4);
        of.append(1).append(3);
    }

    @SuppressWarnings("divzero")
    private static void tryDemo() {
        Try.of(() -> 1 / 0)
                .andThen(r -> System.out.println("and then " + r))
                .onFailure(error -> System.out.println("failure" + error.getMessage()))
                .andFinally(() -> {
                    System.out.println("finally");
                });
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

    public static void main(String[] args) {
        Tuples();
        Functions();
        tryDemo();
        String s = testTryWithRecover(new IllegalStateException());
        System.out.println(s);
    }
}
