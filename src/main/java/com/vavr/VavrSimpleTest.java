package com.vavr;

import io.vavr.Tuple2;
import io.vavr.Value;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import io.vavr.collection.Stream;
import org.junit.Test;

import java.util.function.Predicate;

import static io.vavr.API.*;

/**
 * @author WhomHim
 * @date Create in 2020/8/12 16:40
 */
public class VavrSimpleTest {

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
        String arg = "b";
        Object of = Match(arg).of(
                Case($("a"), () -> run(this::hello)),
                Case($("b"), "2"),
                Case($(), o -> run(() -> {
                    throw new IllegalArgumentException(arg);
                }))
        );
        System.out.println(of);
    }

    @Test
    public void stream() {
        Map<Boolean, List<Integer>> tuple2s = Stream.ofAll(1, 2, 3, 4, 5)
                .groupBy(v -> v % 2 == 0)
                .mapValues(Value::toList);
        System.out.println(tuple2s);
        // 输出 LinkedHashMap((false, List(1, 3, 5)), (true, List(2, 4)))

        Tuple2<List<Integer>, List<Integer>> listTuple2 = Stream.ofAll(1, 2, 3, 4)
                .partition(v -> v > 2)
                .map(Value::toList, Value::toList);
        System.out.println(listTuple2);
        // 输出 (List(3, 4), List(1, 2))

        List<Integer> integers = Stream.ofAll(List.of("Hello", "World", "a"))
                .scanLeft(0, (sum, str) -> sum + str.length())
                .toList();
        System.out.println(integers);
        // 输出 List(0, 5, 10, 11)

        List<Tuple2<Integer, String>> tuple2List = Stream.ofAll(1, 2, 3)
                .zip(List.of("a", "b"))
                .toList();
        System.out.println(tuple2List);
        // 输出 List((1, a), (2, b))
    }

    private void hello() {
        System.out.println("hello world!");
    }

}
