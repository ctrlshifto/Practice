package com.design.pattern.observer;

/**
 * @author WhomHim
 * @description NASA 也能观察到有人登陆月球
 * @date Create in 2020/8/31 10:26
 */
public class Nasa implements LandingObserver {

    @Override
    public void observeLanding(String name) {
        if ("Apollo".contains(name)) {
            System.out.println("We made it!");
        }
    }
}