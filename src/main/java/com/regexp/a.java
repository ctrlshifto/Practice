package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    public static void main(String[] args) {
//        Pattern p = Pattern.compile("a*b");                 //获取到正则表达式
//        Matcher m = p.matcher("aaaaab");                    //获取匹配器
//        boolean b = m.matches();                            //看是否能匹配,匹配就返回true
//
//        System.out.println(b);
//
//        System.out.println("aaaaab".matches("a*b"));        //与上面的结果一样


        String s = "我的手机是18988888888,我曾用过18987654321,还用过18812345678";
        String regex = "1[3578]\\d{9}";


        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);

        boolean b1 = m.find();
        System.out.println(b1);
        //必须调find()方法来找才可以调用group
        System.out.println(m.group());//18988888888
        //进行找的时候,找到一个并会再次调用的时候,
        //便会从之前找到的位置继续向下找,一直到最后
        boolean b2 = m.find();
        System.out.println(b2);
        //必须调find()方法来找才可以调用group
        System.out.println(m.group());//18987654321


        while(m.find())
            System.out.println(m.group());

    }
}
