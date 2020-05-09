package com.guava.event;

import com.google.common.eventbus.Subscribe;
import org.joda.time.Instant;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020/5/9 15:00
 */
public class EventListener2 {

    @Subscribe
    public void test(CustomEvent event) {
        System.out.printf("%s,监听者2,收到事件：%d，线程号为：%s%n", Instant.now(), event.getAge(),
                Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
