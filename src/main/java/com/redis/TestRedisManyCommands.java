package com.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Friend;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author:WhomHim
 * @Description:
 * @Date: Create in 2019/3/21 14:14
 * @Modified by:
 */
public class TestRedisManyCommands {
    JedisPool pool;
    Jedis jedis;
    @Before
    public void setUp() {
        jedis = new Jedis("localhost");
    }

    /**
     * Redis存储初级的字符串
     * CRUD
     */
    @Test
    public void testBasicString(){
        //-----添加数据----------
        //向key-->name中放入了value-->meepo
        jedis.set("name","meepo");
        //执行结果：meepo
        System.out.println(jedis.get("name"));

        //-----修改数据-----------
//        1、在原来基础上修改
        //很直观，类似map 将dota append到已经有的value之后
        jedis.append("name","dota");
        //执行结果:meepodota
        System.out.println(jedis.get("name"));

        //2、直接覆盖原来的数据
        jedis.set("name","poofu");
        //执行结果：poofu
        System.out.println(jedis.get("name"));

        //删除key对应的记录
        jedis.del("name");
        //执行结果：null
        System.out.println(jedis.get("name"));

        /**
         * mset相当于
         * jedis.set("name","meepo");
         * jedis.set("dota","poofu");
         */
        jedis.mset("name","meepo","dota","poofu");
        System.out.println(jedis.mget("name","dota"));

         //设置key name的过期时间为10秒
        jedis.expire("name",10);
    }


    /**
     * jedis操作Map
     */
    @Test
    public void testMap() throws JsonProcessingException {
        Map<String,String>user = new HashMap<String,String>();
        user.put("name","whohim");
        user.put("pwd","password");
        jedis.hmset("user",user);

        List<String>rsmap = jedis.hmget("user","name");
        System.out.println(rsmap);

        System.out.println(jedis.hmget("user","pwd"));
        System.out.println(jedis.hlen("user"));
        System.out.println(jedis.exists("user"));
        System.out.println(jedis.hkeys("user"));
        System.out.println(jedis.hvals("user"));

        Iterator<String> iter=jedis.hkeys("user").iterator();
        while (iter.hasNext()){
            String key = iter.next();
            System.out.println(key+":"+jedis.hmget("user",key));
        }

        //在redis中保存json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        Friend friend = new Friend("yitian", 25);
        String mapValue = objectMapper.writeValueAsString(friend);
        user.put("json",mapValue);
        jedis.hmset("user",user);
    }

    /**
     * jedis操作List
     */
    @Test
    public void testList(){
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework",0,-1));
        jedis.lpush("java framework","spring");
        jedis.lpush("java framework","struts");
        jedis.lpush("java framework","hibernate");
        System.out.println(jedis.lrange("java framework",0,-1));
    }

    /**
     * jedis操作Set
     */
    @Test
    public void testSet(){
        //添加
        jedis.sadd("sname","meepo");
        jedis.sadd("sname","data");
        jedis.sadd("sname","poofu");
        jedis.srem("sname","noname");
        //获取所有加入的value
        System.out.println(jedis.smembers("sname"));
        //判断 meepo 是否是sname集合的元素
        System.out.println(jedis.sismember("sname","meepo"));
        System.out.println(jedis.srandmember("sname"));
        //返回集合的元素个数
        System.out.println(jedis.scard("sname"));
    }

    @Test
    public void test() throws InterruptedException{
        //keys中传入的可以用通配符
        //返回当前库中所有的key  [sose, sanme, name, dota, foo, sname, java framework, user, braand]
        System.out.println(jedis.keys("*"));
        //返回的sname   [sname, name]
        System.out.println(jedis.keys("*name"));
        //删除key为sanmdde的对象  删除成功返回1 删除失败（或者不存在）返回 0
        System.out.println(jedis.del("sanmdde"));
        //返回给定key的有效时间，如果是-1则表示永远有效
        System.out.println(jedis.ttl("sname"));
        //通过此方法，可以指定key的存活（有效时间） 时间为秒
        jedis.setex("timekey", 10, "min");
        //睡眠5秒后，剩余时间将为<=5
        Thread.sleep(5000);
        //输出结果为5
        System.out.println(jedis.ttl("timekey"));
        //设为1后，下面再看剩余时间就是1了
        jedis.setex("timekey", 1, "min");
        //输出结果为1
        System.out.println(jedis.ttl("timekey"));
        //检查key是否存在
        System.out.println(jedis.exists("key"));
        System.out.println(jedis.rename("timekey","time"));
        //因为移除，返回为null
        System.out.println(jedis.get("timekey"));
        //因为将timekey 重命名为time 所以可以取得值 min
        System.out.println(jedis.get("time"));

        //jedis 排序
        //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
        //先清除数据，再加入数据进行测试
        jedis.del("a");
        jedis.rpush("a", "1");
        jedis.lpush("a","6");
        jedis.lpush("a","3");
        jedis.lpush("a","9");
        // [9, 3, 6, 1]
        System.out.println(jedis.lrange("a",0,-1));
        //[1, 3, 6, 9]  //输入排序后结果
        System.out.println(jedis.sort("a"));
        System.out.println(jedis.lrange("a",0,-1));
    }



}




