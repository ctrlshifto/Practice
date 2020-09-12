package com.design.pattern.responsibilitychain;

/**
 * @author WhomHim
 * @description 检查用户角色
 * @date Create in 2020-9-12 09:58:25
 */
public class RoleCheckMiddleware extends Middleware {
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}
