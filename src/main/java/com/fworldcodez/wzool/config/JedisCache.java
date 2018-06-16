package com.fworldcodez.wzool.config;


import com.fworldcodez.wzool.tools.JedisUtil;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.*;

/**
 * redis 缓存
 */
public class JedisCache<K, V> implements Cache, Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(JedisCache.class);
//   @Autowired
//    private static MyConfig myConfig;
    private static final String PREFIX ="SHIRO_SESSION_ID";

    /**
     * @DesCription :处理key值
     */
    public byte[] getByteKey(K k) {
        if (k instanceof String) {
            String key = PREFIX + k;
            return key.getBytes();
        }
        return SerializationUtils.serialize((Serializable) k);
    }

    @Override
    public Object get(Object k) throws CacheException {
        LOGGER.info("get---key="+k);
        if(k!=null){
            Jedis jedis=JedisUtil.getJedis();
            byte[] bytes=jedis.get(getByteKey((K) k));
            JedisUtil.closeJedis(jedis);
            if (bytes!=null){
                return  SerializationUtils.deserialize(bytes);
            }
        }
        return null;
    }

    @Override
    public Object put(Object k, Object v) throws CacheException {
        LOGGER.info("key--"+k+"value--"+v);
        Jedis jedis=JedisUtil.getJedis();
        jedis.set(getByteKey((K) k),SerializationUtils.serialize((Serializable)v));
        jedis.expire(getByteKey((K)k),10000);//设置过期时间
        byte[] bytes=jedis.get(SerializationUtils.serialize(getByteKey((K) k)));
      JedisUtil.closeJedis(jedis);
      if (bytes!=null){
          return SerializationUtils.deserialize(bytes);//反序列化
      }
        return null;
    }

    @Override
    public Object remove(Object k) throws CacheException {
        Jedis jedis=JedisUtil.getJedis();
        byte[] bytes=jedis.get(getByteKey((K) k));
        jedis.del(getByteKey((K) k));
        JedisUtil.closeJedis(jedis);
        if(bytes!=null){
            SerializationUtils.deserialize(bytes);
        }
        return null;
    }

    @Override
    public void clear() throws CacheException {
        JedisUtil.getJedis().flushDB();//清空数据
    }

    @Override
    public int size() {
        Jedis jedis = JedisUtil.getJedis();
        Long size = jedis.dbSize();
        return size.intValue();//输出int数据
    }

    @Override
    public Set<K> keys() {
        Jedis jedis = JedisUtil.getJedis();
        Set<byte[]> bytes = jedis.keys((PREFIX + new String("*")).getBytes());
        Set<K> keys = new HashSet<>();
        if (bytes != null) {
            for (byte[] b : bytes) {
                keys.add(SerializationUtils.deserialize(b));
            }
        }
        JedisUtil.closeJedis(jedis);
        return keys;
    }

    @Override
    public Collection<V> values() {
        Set<K> keys = this.keys();
        Jedis jedis = JedisUtil.getJedis();
        List<V> lists = new ArrayList<>();
        for (K k : keys) {
            byte[] bytes = jedis.get(getByteKey(k));
            lists.add(SerializationUtils.deserialize(bytes));
        }
        JedisUtil.closeJedis(jedis);
        return lists;
    }
}
