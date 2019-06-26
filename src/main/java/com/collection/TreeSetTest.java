package com.collection;


import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        int [] orignalArray  = {1,2,3,4,5,6,3,2,1};
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for (int i = 0;i < orignalArray.length;i ++){
            ts.add(orignalArray[i]);
        }
        Iterator<Integer>i = ts.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
         }
        }
    }


