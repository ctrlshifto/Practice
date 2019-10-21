package com.design.pattern.strategy;

/**
 * @author WhomHim
 * @description
 * @date Create in 2019/10/21 11:23
 */
public class OperationMultiply implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
