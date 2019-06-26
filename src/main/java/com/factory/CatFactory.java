package com.factory;


// 继承着宠物工厂
public class CatFactory implements AnimalFactory {
    @Override
    // 创建猫
    public Animal createAnimal() {
        return new Cat();
    }

    public static void main(String[] args) {
        AnimalFactory af  = new CatFactory();

        Animal aa = af.createAnimal();
        aa.eat();
        System.out.println("店长已经拿了猫过来了");
    }
}
