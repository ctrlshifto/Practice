package com.design.pattern.state;

/**
 * @author WhomHim
 * @description 上下文
 * @date Create in 2019/10/18 18:28
 */
class StateContext {
    private OrderState orderState;

    StateContext(OrderState orderState) {
        this.orderState = orderState;
    }

    void switchStateOrder() {
        orderState.orderService();
    }
}
