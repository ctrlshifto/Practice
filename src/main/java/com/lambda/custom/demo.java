package com.lambda.custom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020-4-11 23:03:36
 */
public class demo {
    public static void main(String[] args) {
        String br =  processFile(BufferedReader::readLine);
        System.out.println(br);
        br = demo.processFile(b -> b.readLine() + b.readLine() + b.readLine());
        System.out.println(br);
    }

    /**
     * 将读取文件的动作封装成参数
     *
     * @param b
     * @return
     */
    public static String processFile(BufferedReaderProcess b) {
        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader("E:\\wspace_idea\\Practice\\src\\main\\java\\com\\lambda\\LambdaSimple.java"))) {
            return b.process(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
