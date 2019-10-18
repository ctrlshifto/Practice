package com.design.pattern.state;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WhomHim
 * @description
 * @date Create in 2019/10/18 18:28
 */
@RestController
public class OrderController {

    @RequestMapping("/order")
    public String order(String stateBeanId) {

        //1.使用Spring上下文获取bean中对象
        OrderState orderState = SpringUtils.getBean(stateBeanId, OrderState.class);
        // 2.使用上下文切换到不同的状态
        StateContext stateContext = new StateContext(orderState);
        stateContext.switchStateOrder();

        // 如果写多重if判断的话 整个代码流程 耗时比较长   直接Spring中精准定位到策略或者是状态的话 Map get方法的时候底层是数组
        return "success";
    }
}