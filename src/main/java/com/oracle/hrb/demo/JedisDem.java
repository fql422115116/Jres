package com.oracle.hrb.demo;

import com.oracle.hrb.bean.User;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.*;

public class JedisDem {
    @Test
    public void test(){
        Jedis jedis = new redis.clients.jedis.Jedis("192.168.134.128",8000);
        jedis.auth("123456");
//        User user  = new User();
//        user.setUsername("张三");
//        user.setPassword("123");
//        jedis.set("张三".getBytes(),toType(user));
        byte[] bs = jedis.get("张三".getBytes());
        User user=(User) toObject(bs);
        System.out.println(user);
        jedis.close();
        System.out.println("执行成功");
    }
    //对象转字节
    public byte[] toType(Object object){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutput oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return baos.toByteArray();
    }
    //字节转对象
    public Object toObject(byte[] bytes){
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream out = new ObjectInputStream(bais);
            try {
                return out.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bais.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
