package com.optional;

import model.User;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author:WhomHim
 * @Description:
 * @Date: Create in 2019/3/27 14:33
 * @Modified by:
 */
public class SimpleOptional {
    public static void main(String[] args) {
        User user = new User();
        User user1 = null;

         //传递进去的对象不可以为null，如果为null则抛出异常
         //Optional<User> op1 = Optional.of(user1);

        // 传递进去的对象可以为null，如果为null则返回一个没有装载对象的Optional容器
        Optional<User> op2 = Optional.ofNullable(user);

        /** ifPresent用法 */
        // 如果存在user，则打印user的name
        op2.ifPresent((value) -> System.out.println(value.getName()));

        // 旧写法
        if (user != null) {
            System.out.println(user.getName());
        }

        /** orElseGet和orElseThrow方法 */
        op2.orElseGet(()-> new User());

        // 旧写法
        if (user != null) {
            user = new User();
        }




    }
}
