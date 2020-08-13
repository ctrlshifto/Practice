package com.redis;

import redis.clients.jedis.Jedis;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020/6/19 11:44
 */
public class TestHyperLogLog {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        for (int i = 0; i < 10000; i++) {
            jedis.pfadd("codehole", "user" + i);
            long total = jedis.pfcount("codehole");
            if (total != i + 1) {
                System.out.printf("%d %d\n", total, i + 1);
                break;
            }
        }
        jedis.close();
    }
}