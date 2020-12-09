package com.vavr;

import io.vavr.control.Option;
import org.junit.Test;

/**
 * @author WhomHim
 * @date Create in 2020/12/9 16:44
 */
public class OptionTest {

    @SuppressWarnings("ConstantConditions")
    @Test
    public void option() {
        int a = 1;
        Option<Integer> when = Option.when(a > 0, a);
        System.out.println(when.get());
    }

}
