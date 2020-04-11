package model;

import java.util.Objects;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020-4-11 21:35:12
 */
public class Apple {
    private String color;
    private int wight;

    public Apple(String color, int wight) {
        this.color = color;
        this.wight = wight;
    }

    public Apple() {
    }

    public Apple(int wight) {
        this.wight = wight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", wight=" + wight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apple apple = (Apple) o;

        if (wight != apple.wight) return false;
        return Objects.equals(color, apple.color);
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + wight;
        return result;
    }
}
