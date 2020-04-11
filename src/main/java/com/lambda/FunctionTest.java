package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*
 * Function<T, R>, T表示传入的类型，R表示返回的类型。即传入T类型的参数，返回R类型的参数
 * @param list
 * @param function
 * @param <T>
 * @param <R>
 * @return
 */
public class FunctionTest {
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("lambda", "test", "javascript");
        List<Integer> map = map(stringList, s -> s.length());
        System.out.println(map);
    }
}