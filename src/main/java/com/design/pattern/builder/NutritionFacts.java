package com.design.pattern.builder;

/**
 * @author WhomHim
 * @description 使用Builder模式的好处如下：
 * <p>
 * 构建器能通过builder方法和setter方法对其参数强加约束条件并且检验，如果不满足条件可以抛出异常；
 * 使用了构建器模式的类可以是不可变的；
 * builder可以有多个可变参数（varargs）；
 * 构建器模式十分灵活，可以利用单个builder构建多个对象，参数可以改变，也可以自动填充；
 * 利用带有泛型的builder可以生成一个抽象工厂。
 * Builder模式的一个缺点就是，你必须自己编写代码创建。
 * <p>
 * 总之，如果类的构造器或者静态工厂方法中含有多个参数，优先选择Builder模式。
 * @date Create in 2019/12/18 14:22
 */
public class NutritionFacts {

    // required
    private final int servingSize;
    private final int servings;

    // optional
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbo;

    public static class Builder {

        private final int servingSize;
        private final int servings;

        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbo = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbo(int val) {
            carbo = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbo = builder.carbo;
    }

    public int getServingSize() {
        return servingSize;
    }

    public int getServings() {
        return servings;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getCarbo() {
        return carbo;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbo(27).build();
        System.out.println("The nutritionfacts of cocaCola \nServing Size: " + cocaCola.servingSize + " ml");
        System.out.println("Servings: " + cocaCola.servings + " per container");
        System.out.println("Calories: " + cocaCola.calories);
        System.out.println("Fat: " + cocaCola.fat + " g");
        System.out.println("Sodium: " + cocaCola.sodium + " mg");
        System.out.println("Carbo: " + cocaCola.carbo + " g");
    }
}