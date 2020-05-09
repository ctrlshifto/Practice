package com.guava.event;

import org.joda.time.Instant;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020/5/9 15:13
 */
public class TestMain {
    public static void main(String[] args) {
        EventListener1 listener1 = new EventListener1();
        EventListener2 listener2 = new EventListener2();
        CustomEvent customEvent = new CustomEvent(23);
        EventBusUtil.register(listener1);
        EventBusUtil.register(listener2);

//        EventBusUtil.post(customEvent);
        EventBusUtil.asyncPost(customEvent);
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s,主线程执行完毕：%s%n", Instant.now(), Thread.currentThread().getName());
    }

}
