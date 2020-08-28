package com.design.pattern.command.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020/8/28 17:12
 */
public class Macro {
    private final List<Action> actions;

    public Macro() {
        actions = new ArrayList<>();
    }

    public void record(Action action) {
        actions.add(action);
    }

    public void run() {
        actions.forEach(Action::perform);
    }
}
