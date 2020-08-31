package com.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WhomHim
 * @description 有东西着陆时会通知这些观察者
 * @date Create in 2020/8/31 10:12
 */
public class Moon {

    private final List<LandingObserver> observers = new ArrayList<>();

    public void land(String name) {
        for (LandingObserver observer : observers) {
            observer.observeLanding(name);
        }
    }

    /**
     * 开始观察
     */
    public void startSpying(LandingObserver observer) {
        observers.add(observer);
    }
}
