package com.factory;


import java.io.FileNotFoundException;
import java.io.Reader;

public class FileOperateA {

    public static void main(String[] args) throws FileNotFoundException {


        //-------我有工厂了，还用自己搞吗？不用了！
        //File file = new File("aa.txt");
        //FileReader fileReader = new FileReader(file);
        //BufferedReader bufferedReader = new BufferedReader(fileReader);
        //-------我有工厂了，还用自己搞吗？不用了！

        // 用工厂来创建出对象
        Reader reader = ReaderFactory.getReader();

        // 读写文件....
    }
}