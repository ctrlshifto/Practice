package com.lambda;

import cn.hutool.json.JSONUtil;
import model.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author WhomHim
 * @description 函数式接口Predicate
 * @date Create in 2019/12/12 19:15
 */
@SuppressWarnings("unchecked")
public class PredicateTest {
    public static void main(String[] args) {
//        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
//
//        System.out.println("Print all languages :");
//        filter(languages, (str) -> true);
//
//        System.out.println("Print no language : ");
//        filter(languages, (str) -> false);
//
//        /* java.util.function.Predicate 允许将两个或更多的 Predicate 合成一个。它提供类似于逻辑操作符AND和OR的方法，
//        名字叫做and()、or()和xor()，用于将传入 filter()           方法的条件合并起来。例如，要得到所有以J开始，长度为
//        四个字母的语言，可以定义两个独立的 Predicate 示例分别表示每一个条件，然后用 Predicate.and()
//        方法将它们合并起来，如下所示： */
//        /*  甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
//          例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入*/
//        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
//        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
//
//        languages.stream()
//                .filter(startsWithJ.and(fourLetterLong))
//                .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));

        List<Apple> appleList = Arrays.asList(new Apple("RED", 80),
                new Apple("GREEN", 100),
                new Apple("BLACK", 150));
        // 重量大于100
        List<Apple> filterApple = filterApple(appleList, apple -> apple.getWight() > 100);
        System.out.println(JSONUtil.toJsonPrettyStr(filterApple));

        // 红色的苹果
        filterApple = filterApple(appleList, apple -> apple.getColor().equals("RED"));
        System.out.println(JSONUtil.toJsonPrettyStr(filterApple));


    }

    public static List<Apple> filterApple(List<Apple> appleList, Predicate<Apple> predicate){
        return appleList.stream().filter(predicate::test).collect(Collectors.toList());
    }

    private static void filter(List names, Predicate condition) {
        for (Object name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }
}
