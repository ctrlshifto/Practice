package com.lambda.custom;


import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author WhomHim
 * @description 读取流的函数式编程，把行为参数化
 * @date Create in 2020-4-11 23:02:42
 */
@FunctionalInterface // 注意这个注解
public interface BufferedReaderProcess {

    String process(BufferedReader b) throws IOException;

}