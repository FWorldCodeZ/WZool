package com.fworldcodez.wzool.config;

import com.fworldcodez.wzool.tools.JedisUtil;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.io.Serializable;


public class RedisSessionDao extends CachingSessionDAO {

    @Autowired
    private static MyConfig myConfig;

    // private static String PREFIX = myConfig.sessionPrefix;
    private static final String PREFIX = "SHIRO_SESSION_ID";
    private static final int EXPRIE = 10000;
    //  private static final int EXPRIE = myConfig.jedisExprie;
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisSessionDao.class);

    private byte[] getByteKey(Object k) {
        if (k instanceof String) {
            String key = PREFIX + k;
            return key.getBytes();
        } else {
            return SerializationUtils.serialize((Serializable) k);
        }
    }
    @Override
    protected Serializable doCreate(Session session) {// 加入session
        LOGGER.info("-------doCreate--------");
        Serializable serializable = this.generateSessionId(session);
        assignSessionId(session, serializable);
        Jedis jedis = JedisUtil.getJedis();
        session.setTimeout(EXPRIE * 1000);
         /*jedis.set(getByteKey(serializable),SerializationUtils.serialize((Serializable)session));
        jedis.expire(SerializationUtils.serialize(getByteKey(serializable)),EXPRIE);*/
        jedis.setex(getByteKey(serializable), EXPRIE, SerializationUtils.serialize((Serializable) session));
        JedisUtil.closeJedis(jedis);
        return serializable;
    }
    @Override
    protected void doUpdate(Session session) {
        LOGGER.info("--------doUpdate-----");
        if (session == null) {
            return;
        }
        Jedis jedis = JedisUtil.getJedis();
        session.setTimeout(EXPRIE * 1000);
        /*jedis.set(getByteKey(session.getId()),SerializationUtils.serialize((Serializable)session));
       jedis.expire(SerializationUtils.serialize((PREFIX+session.getId())),EXPRIE);*/
        LOGGER.info("--------session-----"+session.getId());
        jedis.setex(getByteKey(session.getId()),EXPRIE,SerializationUtils.serialize((Serializable)session) );
        JedisUtil.closeJedis(jedis);
    }

    @Override
    protected void doDelete(Session session) {
        LOGGER.info("--------doDelete-----");
        Jedis jedis = JedisUtil.getJedis();
        jedis.del(getByteKey(session.getId()));
        JedisUtil.closeJedis(jedis);
    }



    @Override
    protected Session doReadSession(Serializable serializable) {// 读取session
        LOGGER.info("-----doReadSession-------");
        Jedis jedis = JedisUtil.getJedis();
        Session session = null;
        byte[] bytes = jedis.get(getByteKey(serializable));
        if (bytes != null) {
            session = SerializationUtils.deserialize(bytes);
            jedis.expire((PREFIX + serializable).getBytes(), EXPRIE);
        }
        //判断是否有会话，没有则返回null
        if (serializable == null) {
            return null;
        }
        JedisUtil.closeJedis(jedis);
        return session;
    }

}
