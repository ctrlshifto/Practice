package com.design.pattern.singletonpattern;

public class DlcLazyEmperor {
    private DlcLazyEmperor(){

    }
    private static volatile DlcLazyEmperor dlcLazyEmperor = null;

    public static DlcLazyEmperor getDlcLazyEmperor(){
        if (dlcLazyEmperor == null){// 将锁范围缩小,提高性能
               synchronized(DlcLazyEmperor.class){
                   //再判断一次是否为空
                   if (dlcLazyEmperor == null){
                       dlcLazyEmperor = new DlcLazyEmperor();
                       // 其实锁住这里面，有一次判断为空就够了，
                       // 外面那个判断为空主要为了提高性能
                   }
               }
        }
        return dlcLazyEmperor;
    }
    public static void say(){
        System.out.println("我就是DLC懒汉皇帝某某某");
    }
}
