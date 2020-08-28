package com.design.pattern.command.lambda;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author WhomHim
 * @description 命令模式
 * @date Create in 2020/8/28 17:14
 */
public class CommandTest {

    @Autowired
    public FileReceiver fileReceiver;

    @Test
    public void asd() {
        Macro macro = new Macro();
        macro.record(fileReceiver::openFile);
        macro.record(fileReceiver::writeFile);
        macro.record(fileReceiver::closeFile);
        macro.run();
    }
}
