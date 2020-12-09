package com.vavr;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import org.junit.Test;

/**
 * @author WhomHim
 * @date Create in 2020/12/9 16:44
 */
public class TuplesTest {

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
}
