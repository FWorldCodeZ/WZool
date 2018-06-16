package com.fworldcodez.wzool.tools;

import com.fworldcodez.wzool.config.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
    private static JedisPool jedisPool;
   // private  static  MyConfig myConfig;
    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxWaitMillis(100);
//        String host=MyConfig.jedisHost;
//        Integer port=MyConfig.jedisPort;
        jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379,30000,"root");
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    public static void closeJedis(Jedis jedis){
        jedis.close();
    }
}
