package com.design.pattern.command;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020/8/28 17:10
 */
public class OpenFile implements Action {
    private final FileReceiver fileReceiver;

    public OpenFile(FileReceiver fileReceiver) {
        this.fileReceiver = fileReceiver;
    }

    @Override
    public void perform() {
        fileReceiver.openFile();
    }
}
