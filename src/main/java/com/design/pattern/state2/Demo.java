package com.design.pattern.state2;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020-9-12 10:15:16
 */
public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
