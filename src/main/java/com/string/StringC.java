package com.string;

public class StringC {
    public static void main(String[] args) {
        //常量池没有这个字符串对象,就创建一个,如果有直接用即可
        String s1 = "abc";//在常量池中
        String s2 = new String("abc");//在堆内存中
        System.out.println(s1 == s2);   //false
        System.out.println(s1.equals(s2));//true
    }
}
