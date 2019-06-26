package com.selecttopic;

public class Inc {

    public static void main(String[] args) {
        Inc inc = new Inc();
        int i = 0;int a = 0;
        inc.fermin(i);
        i= i ++;
        System.out.println(i);
        a= ++i;
        System.out.println(a);

    }
    void fermin(int i){
        i++;
    }
}
