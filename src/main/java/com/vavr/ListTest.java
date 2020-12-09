package com.vavr;

import io.vavr.collection.List;
import org.junit.Test;

/**
 * @author WhomHim
 * @date Create in 2020/12/9 16:42
 */
public class ListTest {

    @Test
    public void list() {
        // vavr 的 List 是不可变的
        List<Integer> of = List.of(1, 2, 3, 4);
        List<Integer> prepend = of.prepend(1).prepend(3);
        System.out.println(of);
        System.out.println(prepend);
    }
}
