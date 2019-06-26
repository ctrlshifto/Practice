package com.exersise;

public class StringReverse {
    public static void main(String []args) {
        String s ="i love java";
        String b = "hello";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.reverse().toString());

    }

    public static String reverse1(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
