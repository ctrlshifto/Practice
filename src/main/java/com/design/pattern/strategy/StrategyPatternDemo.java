package com.design.pattern.strategy;

import com.withoutIf.IfFunction;

import java.util.HashMap;

/**
 * @author WhomHim
 * @description
 * @date Create in 2019/10/21 11:25
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));

        System.out.println("----- 利用lambda表达式简化的策略模式：");
        Context context2 = new Context(Integer::sum);
        System.out.println("10 + 5 = " + context2.executeStrategy(10, 5));
        System.out.println(context2);
        System.out.println("----- 利用lambda表达式简化的策略模式");

        /* use without if */
        IfFunction<String> ifFunction = new IfFunction<>(new HashMap<>(5));

        ifFunction
                .add("加法", () -> System.out.println(new Context(new OperationAdd()).executeStrategy(10, 5)))
                .add("减法", () -> System.out.println(new Context(new OperationSubstract()).executeStrategy(10, 5)))
                .doIfWithDefault("乘法", () -> System.out.println(new Context(new OperationMultiply()).executeStrategy(10, 5)));

        ifFunction.doIf("加法");
        ifFunction.doIf("减法");
        ifFunction.doIf("乘法");
    }
}
