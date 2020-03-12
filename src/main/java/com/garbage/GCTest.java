package com.garbage;

/**
 * @Author:WhomHim
 * @Description: 对象优先在 eden 区分配
 * @Date: Create in 2020-3-6 23:42:08
 * @Modified by:
 */
public class GCTest {

    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[50900 * 1024];
        allocation2 = new byte[900*1024];
    }
}