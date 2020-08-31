package com.design.pattern.observer;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020/8/31 10:29
 */
public class ObserverDemo1 {
    public static void main(String[] args) {
        Moon moon = new Moon();
        moon.startSpying(new Nasa());
        moon.startSpying(new Aliens());
        moon.land("An asteroid");
        moon.land("Apollo 11");
    }
}
