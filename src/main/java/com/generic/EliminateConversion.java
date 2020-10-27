package com.generic;

/**
 * @author WhomHim
 * @description 使用泛型消除类型转换
 * @date Create in 2020/10/26 15:30
 */
@SuppressWarnings("rawtypes")
public class EliminateConversion<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        // do nothing
    }

    /**
     * 不指定类型
     */
    @SuppressWarnings("unchecked")
    public void noSpecifyType() {
        EliminateConversion eliminateConversion = new EliminateConversion();
        eliminateConversion.set("test");
        // 需要强制类型转换
        String test = (String) eliminateConversion.get();
        System.out.println(test);
    }

    /**
     * 指定类型
     */
    public void specifyType() {
        EliminateConversion<String> eliminateConversion = new EliminateConversion();
        eliminateConversion.set("test");
        // 不需要强制类型转换
        String test = eliminateConversion.get();
        System.out.println(test);
    }
}
