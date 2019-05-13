package com.util;

import cn.hutool.core.util.NetUtil;

import javax.swing.*;

/**
 * @author WhomHim
 * @description 判断ActiveMQ是否启动
 * @date Create in 2019/5/13 11:04
 */
public class ActiveMqUtil {

    private static final int ACTIVE_MQ_PORT = 8161;

    public static void main(String[] args) {
        checkServer();
    }

    public static void checkServer() {
        if (NetUtil.isUsableLocalPort(ACTIVE_MQ_PORT)) {
            JOptionPane.showMessageDialog(null, "activemq 服务器未启动 ");
            System.exit(1);
        }
    }
}
