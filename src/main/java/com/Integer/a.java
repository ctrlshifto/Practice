package com.Integer;

public class a {


    public static void main(String[] args) {
        Integer i1 = new Integer(97);
        Integer i2 = new Integer(97);
        System.out.println(i1 == i2); // false
        System.out.println(i1.equals(i2)); // true
        System.out.println("-----------");

        Integer i3 = new Integer(197);
        Integer i4 = new Integer(197);
        System.out.println(i3 == i4); // false
        System.out.println(i3.equals(i4)); // true
        System.out.println("-----------");

        Integer i5 = 127;
        Integer i6 = 127;
        System.out.println(i5 == i6); // true
        System.out.println(i5.equals(i6)); // true
        System.out.println("-----------");

        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8);// false
        System.out.println(i7.equals(i8)); // true


    }
}
