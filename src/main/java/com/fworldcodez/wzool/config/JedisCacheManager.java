package com.fworldcodez.wzool.config;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Desciption 主要用于创建 JedisCache
 */
public class JedisCacheManager implements CacheManager {
    private static final Logger logger = LoggerFactory.getLogger(JedisCacheManager.class);
    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<>();

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        logger.info("getCache--"+s);
        Cache cache = caches.get(s);
        if (cache == null) {
            cache = new JedisCache();
            caches.put(s, cache);
        }
        return cache;
    }
}
