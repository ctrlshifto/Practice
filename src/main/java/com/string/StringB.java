package com.string;

import java.util.logging.Logger;

public class StringB {
    private static final Logger logger = Logger.getLogger("com.whohim.top");

    public static void main(String[] args) {
        //常量池没有这个字符串对象,就创建一个,如果有直接用即可
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);   //true
        System.out.println(s1.equals(s2));//true


    }
}
