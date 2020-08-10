package com.oracle.hrb.demo;

import com.oracle.hrb.bean.User;

public class Hello {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("张三");
        String username = user.getUsername();
        System.out.print(username);
        System.out.println("张思");

    }
}
