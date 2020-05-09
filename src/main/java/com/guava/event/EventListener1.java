package com.guava.event;

import com.google.common.eventbus.Subscribe;
import org.joda.time.Instant;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020/5/9 14:59
 */
public class EventListener1 {
    @Subscribe
    public void test1(CustomEvent event) {
        System.out.printf("%s监听者1-->订阅者1,收到事件：%d，线程号为：%s%n", Instant.now(), event.getAge(),
                Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void test2(CustomEvent event) {
        System.out.printf("%s监听者1-->订阅者2,收到事件：%d，线程号为：%s%n", Instant.now(), event.getAge(),
                Thread.currentThread().getName());
    }
}