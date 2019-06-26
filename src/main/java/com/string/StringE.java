package com.string;

public class StringE {
    public static void main(String[] args) {
        String s1="ab";
        String s2="abc"; //在常量池中
        String s3= s1+"c";//在堆内存中
        System.out.println(s2 == s3);   //false
        System.out.println(s2.equals(s3));//true

        System.gc();
        Thread a = new Thread();
        a.start();



         int i=10;


    }
}
