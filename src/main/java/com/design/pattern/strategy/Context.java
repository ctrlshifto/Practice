package com.design.pattern.strategy;

/**
 * @author WhomHim
 * @description
 * @date Create in 2019/10/21 11:23
 */
class Context {
    private Strategy strategy;

    Context(Strategy strategy) {
        this.strategy = strategy;
    }

     @SuppressWarnings("SameParameterValue")
     int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
