package com.factory;


import java.io.*;

// 创建Reader对象的工厂
public class ReaderFactory {
    public static Reader getReader() throws FileNotFoundException {
        File file = new File("aa.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        return reader;
    }
}
