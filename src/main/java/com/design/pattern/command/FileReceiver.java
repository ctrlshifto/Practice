package com.design.pattern.command;

import org.springframework.stereotype.Service;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020/8/28 17:08
 */
@Service
public interface FileReceiver {
    void openFile();

    void writeFile();

    void closeFile();
}
