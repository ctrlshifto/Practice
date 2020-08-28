package com.design.pattern.command.normal;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020/8/28 17:53
 */
public class Client {
    public static void main(String[] args) {
        Command c = new ConcreteCommand(new Receiver());
        Invoke i = new Invoke(c);
        i.call();
    }
}
