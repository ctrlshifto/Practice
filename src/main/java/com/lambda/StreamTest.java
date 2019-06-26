package com.lambda;


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
        /* 1.Array */
//        string[] array = (string[]) stream.toArray(string[]::new);
//        /* 2.collection */
//        List<string>list1 = (List<string>) stream.collect(Collectors.toList());
//        List<string>list2 = (List<string>) stream.collect(Collectors.toCollection(arrayList::new));
//        /* 3.string */
//        string str = stream.collect(Collectors.joining()).toString();
//        /* 一个 Stream 只可以使用一次，上面的代码为了简洁而重复使用了数次。 */

        /**
         *  清单 8. 平方数
         */
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(squareNums);


    }
}
