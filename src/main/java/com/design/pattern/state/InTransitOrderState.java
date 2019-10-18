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
public class InTransitOrderState implements OrderState {
    @Override
    public String orderService() {
//        log.info(">>>切换为正在运送状态...");
        return "success";
    }
}