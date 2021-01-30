package com.design.pattern.template;

/**
 * <p> 传统的模板方法模式</p>
 * <p>http://c.biancheng.net/view/1376.html</p>
 *
 * @author WhomHim
 * @date Create in 2020/12/3 15:02
 */
public class TemplateMethodPattern {
    public static void main(String[] args) {
        AbstractClass tm = new ConcreteClass();
        tm.templateMethod();
    }
}
