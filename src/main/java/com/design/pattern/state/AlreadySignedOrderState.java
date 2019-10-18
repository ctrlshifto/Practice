package com.design.pattern.state;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author WhomHim
 * @description
 * @date Create in 2019/10/18 17:25
 */

@Component
public class AlreadySignedOrderState implements OrderState {

    @Override
    public Object orderService() {
//        log.info(">> 切换已经签收状态");
        return "切换已经签收状态";
    }
}
