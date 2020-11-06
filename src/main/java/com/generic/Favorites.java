package com.generic;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author WhomHim
 * @description <p>类型安全的异构容器模式-实现</p>
 * <p>https://github.com/clxering/Effective-Java-3rd-edition-Chinese-English-bilingual
 * /blob/master/Chapter-5/Chapter-5-Item-33-Consider-typesafe-heterogeneous-containers.md</p>
 * @date Create in 2020/11/6 18:43
 */
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    /**
     * 使用as子类安全地转换为有界类型标记
     */
    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        // Unbounded type token
        Class<?> annotationType;
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }

    public static void main(String[] args) {
        // 类型安全的异构容器模式 - 调用
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
    }
}


