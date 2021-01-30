package com.design.pattern.template;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/1/30 17:30
 */
public class ConcreteClass extends AbstractClass {
    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }
}
