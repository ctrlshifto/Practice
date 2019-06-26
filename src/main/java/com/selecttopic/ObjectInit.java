package com.selecttopic;

 class SuperClass {
    private static String STR = " Super Class Static Variable 父类静态私有变量";

    static {
        System.out.println("Super Class Static Block: 父类静态代码块" + STR);
    }

    public SuperClass() {
        System.out.println("Super Class Constructor Method 父类构造方法");
    }

    {
        System.out.println("Super Class Block 父类非静态代码块");
    }

}

public class ObjectInit extends SuperClass {
    private static String STR = " Class Static Variable 子类静态私有变量";

    static {
        System.out.println("Class Static Block: 子类静态代码块" + STR);
    }

    public ObjectInit() {
        System.out.println("Constructor Method 子类构造方法");
    }

    {
        System.out.println("Class Block 子类非静态代码块");
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        ObjectInit a = new ObjectInit();
    }
}

