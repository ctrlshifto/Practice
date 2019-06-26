package com.exersise;

import SetAndMap.MaxHeap.Array;

public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("com.exersise.Student(name: %s, score: %d)",name,score);
    }

    public static void main(String[] args){
        Array<Student> array = new Array<>();
        array.addLast(new Student("Alice",100));
        array.addLast(new Student("xiaoming",60));
        array.addLast(new Student("xiaohong",70));
        System.out.println(array);

    }
}
