package com.generic;

import com.design.pattern.factory.Animal;
import com.design.pattern.factory.Cat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WhomHim
 * @description 无界通配符
 * <p>https://www.cnblogs.com/minikobe/p/11547220.html</p>
 * @date Create in 2020/10/26 15:40
 */
public class UnboundedWildcards {
    /**
     * 用 extends 关键字声明，表示参数化的类型可能是所指定的类型，或者是此类型的子类。
     */
    static void countLegs(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    static void countLegs1(List<Animal> animals) {
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    public static void main(String[] args) {
        List<Cat> dogs = new ArrayList<>();
        // 不会报错
        countLegs(dogs);
        // 报错
//        countLegs1(dogs);
    }
}
