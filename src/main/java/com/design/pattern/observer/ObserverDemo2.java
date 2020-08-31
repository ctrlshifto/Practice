package com.design.pattern.observer;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020/8/31 10:31
 */
public class ObserverDemo2 {
    public static void main(String[] args) {
        Moon moon = new Moon();
        moon.startSpying(name -> {
            if ("Apollo".contains(name)) {
                System.out.println("We made it!");
            }
        });
        moon.startSpying(name -> {
            if ("Apollo".contains(name)) {
                System.out.println("They're distracted, lets invade earth!");
            }
        });
        moon.land("An asteroid");
        moon.land("Apollo 11");
    }
}
