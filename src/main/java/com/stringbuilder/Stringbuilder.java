package com.stringbuilder;

public class Stringbuilder {
    public static void main(String[] args) {
        //在堆内存创建了一个对象
        StringBuffer sb = new StringBuffer();
        //sb1,sb2指向的地址都是同一个(变长),这个要区别String类定长的概念
        StringBuffer sb1 = sb.append(true);
        StringBuffer sb2 = sb.append("luoshijie");

        System.out.println(sb1);//trueluoshijie
        System.out.println(sb2);////trueluoshijie
        /**解释:StringBuffer是字符串缓冲区,当new的时候是在堆内存创建了一个对象,底层是一个长度为16的字符数组
         当调用添加的方法时,不会再重新创建对象,在不断向原缓冲区添加字符*/

    }

}
