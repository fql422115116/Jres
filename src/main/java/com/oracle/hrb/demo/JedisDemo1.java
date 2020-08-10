package com.oracle.hrb.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.sql.*;
import java.util.Map;
import java.util.Set;

public class JedisDemo1 {
    private Connection connection;
    public void mysqlToRedis(Jedis jedis)  {
        try {
            String sql = "select * from first_student";
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/java1915","root","root");
            Statement st = connection.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while (rs.next()){
                jedis.hset("00",rs.getInt(1)+"",rs.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void redisToMysql(Jedis jedis)  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/java1915","root","root");
            Map<String ,String> map = jedis.hgetAll("00");
            Set<String> m= map.keySet();
            for(String str :m){
                Statement st =connection.createStatement();
                ResultSet rs = st.executeQuery("select *from first_student where s_id ="+str);
                while (rs.next()){
                    jedis.hset(str,rs.getInt(1)+"",rs.getString(2));
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void test(){
        Jedis jedis = new Jedis("192.168.134.128", 8000);
        jedis.auth("123456");
        mysqlToRedis(jedis);
        jedis.close();
        System.out.println("成功");
    }
    @Test
    public void test1(){
        Jedis jedis = new Jedis("192.168.134.128", 8000);
        jedis.auth("123456");
        redisToMysql(jedis);
    }
}
