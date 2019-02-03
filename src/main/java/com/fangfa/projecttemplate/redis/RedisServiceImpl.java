package com.fangfa.projecttemplate.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @Auther 葛林
 * @Date 2019/2/3 15:30
 * @describe
 */
@Service
@SuppressWarnings({ "rawtypes", "unchecked" })
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public void set(String key, Object val) {
         redisTemplate.opsForValue().set(key, val);
    }

    @Override
    public void set(String key, Object val, long expireTime) {
        set(key,val);
        redisTemplate.expire(key,expireTime,TimeUnit.SECONDS);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void remove(String key) {
        if(exists(key)){
            redisTemplate.delete(key);
        }
    }

    @Override
    public void remove(String... keys) {
        for (String key:keys) {
            remove(key);
        }
    }

    @Override
    public void removeByPattern(String pattern) {
        Set set = redisTemplate.keys(pattern);
        if(set.size()>0){
            redisTemplate.delete(set);
        }
    }

    @Override
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }


    @Override
    public void hmSet(String key, Object hashKey, Object val) {
       redisTemplate.opsForHash().put(key,hashKey,val);
    }

    @Override
    public Object hmGet(String key, Object hashKey) {
        return redisTemplate.opsForHash().get(key,hashKey);
    }

    @Override
    public void pushList(String key, Object val) {
       redisTemplate.opsForList().rightPush(key,val);
    }

    @Override
    public List<Object> listRange(String key, long start, long end) {
        return redisTemplate.opsForList().range(key,start,end);
    }

    @Override
    public void setAdd(String key, Object val) {
       redisTemplate.opsForSet().add(key,val);
    }

    @Override
    public Set<Object> setMembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    @Override
    public void zAdd(String key, Object val,double scour) {
        redisTemplate.opsForZSet().add(key,val,scour);
    }

    @Override
    public Set<Object> rangeByScore(String key, double scour, double scour1) {
        return redisTemplate.opsForZSet().rangeByScore(key, scour, scour1);
    }
}
