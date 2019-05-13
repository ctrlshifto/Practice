package com.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:WhomHim
 * @Description:
 * @Date: Create in 2019-3-17 15:07:20
 * @Modified by:
 */
public class SortSet {
    public static void main(String[] args) {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        // 1.1 使用匿名内部类根据 name 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });
    }
}
