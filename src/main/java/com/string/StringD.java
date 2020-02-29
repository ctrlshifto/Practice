package com.string;

public class StringD {
    public static void main(String[] args) {
        byte b1 = 3;
        byte b2 = 4;
        byte b3 = (byte) (b1 + b2);//这里是变量里面的值相加,jvm无法知道里面的值是多少,所以可能会溢出的安全问题,所以需要强转
        byte b4 = 3 + 4;//jvm有常量优化机制,在编译时候就变成了7,接着把7赋值给b4
        System.out.println(b3 == b4);//true


        String s1 = "a" + "b" + "c";//jvm常量优化机制,类似byte b4=3+4;
        String s2 = "abc";
        String s3 = "ab";
        String s4 = "c";
        String s5 = s3 + s4;
        System.out.println(s1);
        System.out.println(s5);
        System.out.println(s5 == s1);//false
        System.out.println(s5.equals(s2));//true
        System.out.println(s1 == s2);   //true,常量优化机制
        System.out.println(s1.equals(s2));//true

    }
}
