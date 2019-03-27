package com.Lambda;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



/**
 * @Author:WhomHim
 * @Description:
 * @Date: Create in 2019/3/27 15:19
 * @Modified by:
 */
public class StreamTest {
    public static void main(String[] args) {
        /**
         * 清单 4. 构造流的几种常见方法
         */
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");
        // 2. Arrays
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
        /**
         * 清单 5. 数值流的构造
         */
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

        /**
         * 清单 6. 流转换为其它数据结构
         */
        String[] array = (String[]) stream.toArray(String[]::new);
        List<String>list1 = (List<String>) stream.collect(Collectors.toList());

    }
}
