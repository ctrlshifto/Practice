package com.withoutIf;

import java.util.Map;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020-4-10 23:17:35
 */
public class IfFunction<K> {

    private Map<K, Function> map;

    /**
     * the IfFunction need a map to save keys and functions
     *
     * @param map a map
     */
    public IfFunction(Map<K, Function> map) {
        this.map = map;
    }

    /**
     * add key and function to the map
     *
     * @param key      the key need to verify
     * @param function it will be executed when the key exists
     * @return this.
     */
    public IfFunction<K> add(K key, Function function) {
        this.map.put(key, function);
        return this;
    }

    /**
     * Determine whether the key exists, and if there is, the corresponding method is executed.
     *
     * @param key the key need to verify
     */
    public void doIf(K key) {
        if (this.map.containsKey(key)) {
            map.get(key).invoke();
        }
    }

    /**
     * Determine whether the key exists, and if there is, the corresponding method is executed.
     * otherwise the defaultFunction is executed.
     *
     * @param key             the key need to verify
     * @param defaultFunction it will be executed when the key is not exists.
     */
    public void doIfWithDefault(K key, Function defaultFunction) {
        if (this.map.containsKey(key)) {
            map.get(key).invoke();
        } else {
            defaultFunction.invoke();
        }
    }

}