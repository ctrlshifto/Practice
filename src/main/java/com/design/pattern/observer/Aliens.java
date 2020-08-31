package com.design.pattern.observer;

/**
 * @author WhomHim
 * @description 外星人观察到人类登陆月球
 * @date Create in 2020/8/31 10:19
 */
public class Aliens implements LandingObserver{

    @Override
    public void observeLanding(String name) {
        if ("Apollo".contains(name)) {
            System.out.println("They're distracted, lets invade earth!");
        }
    }
}
