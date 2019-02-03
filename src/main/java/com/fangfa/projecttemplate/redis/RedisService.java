package com.fangfa.projecttemplate.redis;

import java.util.List;
import java.util.Set;

/**
 * create gl  2019/2/3
 **/
public interface RedisService {
    void set(String key,Object val);
    //设置过期时间,秒为单位
    void set(String key,Object val,long expireTime);
    Object get(String key);
    void remove(String key);
    void remove(String... keys);
    //根据规则删除所有的值
    void removeByPattern(String pattern);
    //判断是否有这个key
    boolean exists(String key);
    //hash添加,map
    void hmSet(String key,Object hashKey,Object val);
    Object hmGet(String key,Object hashKey);
    //列表添加  list
    void pushList(String key,Object val);
    List<Object> listRange(String key,long start,long end);
    //set添加
    void setAdd(String key,Object val);
    Set<Object> setMembers(String key);
    //有序set
    void zAdd(String key,Object val,double scour);
    Set<Object> rangeByScore(String key,double scour,double scour1);
}
