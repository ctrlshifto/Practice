package com.simgleton_pattern;

public class StaticInnerClassLazy {
    private StaticInnerClassLazy(){

    }
    //使用内部类的方式来实现懒加载
    private static class LazyHolder{
        //创建单例对象
        private static final StaticInnerClassLazy INSTANCE = new StaticInnerClassLazy();
    }
    //获取对象
    public static final StaticInnerClassLazy getInstance(){
        return LazyHolder.INSTANCE;
    }
    public static void say(){
        System.out.println("我就是静态内部类懒汉式皇帝...");
    }
}
