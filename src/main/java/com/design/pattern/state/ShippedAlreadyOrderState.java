package com.design.pattern.state;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author WhomHim
 * @description
 * @date Create in 2019/10/18 17:27
 */
//@Slf4j
@Component
public class ShippedAlreadyOrderState implements OrderState {

    @Override
    public String orderService() {
//        log.info(">>>切换为已经发货状态..");
        return "已经发货..";
    }
}