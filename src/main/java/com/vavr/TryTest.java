package com.vavr;

import io.vavr.control.Try;
import org.junit.Test;

import static io.vavr.API.*;

/**
 * @author WhomHim
 * @date Create in 2020/12/9 16:42
 */
public class TryTest {

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

    public static void main(String[] args) {
        String testTryWithRecover = testTryWithRecover(new IllegalStateException());
        System.out.println(testTryWithRecover);
        String bmiFormat = bmiFormat(175, 60);
        System.out.println(bmiFormat);
    }
}
