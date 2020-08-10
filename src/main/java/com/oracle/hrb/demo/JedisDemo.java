package com.oracle.hrb.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.hrb.bean.User;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.*;

public class JedisDemo {
    @Test
    public void test() throws IOException {
        Jedis jedis = new Jedis("192.168.134.128", 8000);
        jedis.auth("123456");
        //json存储
//        User user = new User();
//        user.setUsername("李四");
//        user.setPassword("123");
//        ObjectMapper mapper = new ObjectMapper();
//        jedis.set("date",mapper.writeValueAsString(user));
        //取
        ObjectMapper mapper  = new ObjectMapper();
        System.out.println(mapper.readValue(jedis.get("date"),User.class));

        jedis.close();
        System.out.println("执行成功");
    }
}
