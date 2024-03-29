package com.auth.center.springsecurity.common.util;

import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Redis工具类
 *
 * @author Li qiangqiang
 * @date 2017-07-17 21:12
 */
@Component
public class RedisUtils {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate redisTemplate;
    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;

    /**
     * 默认过期时长，单位：秒
     */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;
    /**
     * 加锁过期时长，单位：秒
     */
    public final static long LOCK_EXPIRE = 60 * 60;
    /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1;
    private final static Gson GSON = new Gson();

    //=============================common============================

    /**
     * 指定缓存失效时间
     *
     * @param key 键
     * @param time 时间(秒)
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public long getExpire( String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey( String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void del( String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete( key[0]);
            } else {
                redisTemplate.delete(key);
            }
        }
    }

    //============================String=============================

    /**
     * 普通缓存放入并设置时间
     *
     * @param key 键
     * @param value 值
     * @param expire 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public void set( String key, Object value, long expire) {
        if(expire != NOT_EXPIRE){
            valueOperations.set(key, toJson(value),expire,TimeUnit.SECONDS);
        }else{
            valueOperations.set(key, toJson(value));
        }
//        if (expire != NOT_EXPIRE) {
//            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
//        }
    }

    /**
     * 普通缓存放入
     *
     * @param key 键
     * @param value 值
     * @return true成功 false失败
     */
    public void set( String key, Object value) {
        set( key, value, NOT_EXPIRE);
    }

    public <T> T get( String key, Class<T> clazz, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJson(value, clazz);
    }

    /**
     * 普通Model缓存获取
     *
     * @param key 键,clazz
     * @return T 值
     */
    public <T> T get( String key, Class<T> clazz) {
        return get( key, clazz, NOT_EXPIRE);
    }

    /**
     * 普通string缓存获取
     *
     * @param key 键,expire 更新缓存失效时间
     * @return T 值
     */
    public String get( String key, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    /**
     * 普通缓存获取
     *
     * @param key 键,clazz
     * @return string 值
     */
    public String get( String key) {
        return get( key, NOT_EXPIRE);
    }


    /**
     * 递增
     *
     * @param key 键
     * @param delta 要增加几(大于0)
     */
    public long incr( String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     *
     * @param key 键
     * @param delta 要减少几(小于0)
     */
    public long decr( String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    //================================Map=================================

    /**
     * HashGet
     *
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    public Object hget( String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }


    /**
     * HashGet
     *
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    public <T> T hget( String key, String item, Class<T> clazz) {
        String value = (String) redisTemplate.opsForHash().get(key, item);
        return value == null ? null : fromJson(value, clazz);

    }

    /**
     * 获取hashKey对应的所有键值
     *
     * @param key 键
     * @return 对应的多个键值
     */
    public Map<Object, Object> hmget( String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * HashSet
     *
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    public boolean hmset( String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * HashSet 并设置时间
     *
     * @param key 键
     * @param map 对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    public boolean hmset( String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire( key, time);
            }
            return true;
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key 键
     * @param item 项
     * @param value 值
     * @return true 成功 false失败
     */
    public boolean hset( String key, String item, Object value) {
        try {
            int cs = 1; // 向Redis中入数据的次数
            while(true){
                redisTemplate.opsForHash().put(key, item, value);
                if(cs > 3 || hasKey( key)){
                    break;
                }else{
                    cs ++;
                }
            }
            if(cs > 3){
                throw new Exception("向Redis插入数据失败，请稍后再试");
            }
            return true;
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     * 并指定缓存失效时间
     *
     * @param key 键
     * @param item 项
     * @param value 值
     * @param time 时间(秒)  注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    public boolean hset( String key, String item, Object value,
        long time) {
        try {
            int cs = 1; // 向Redis中入数据的次数
            while(true){
                redisTemplate.opsForHash().put(key, item, value);
                // 如果缓存失效时间大于0，则指定缓存失效时间
                if (time > 0) {
                    expire( key, time);
                }
                if(cs > 3 || hasKey( key)){
                    break;
                }else{
                    cs ++;
                }
            }
            if(cs > 3){
                throw new Exception("向Redis插入数据失败，请稍后再试");
            }
            return true;
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除hash表中的值
     *
     * @param key 键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    public void hdel( String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    public boolean hHasKey( String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key 键
     * @param item 项
     * @param by 要增加几(大于0)
     */
    public double hincr( String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * hash递减
     *
     * @param key 键
     * @param item 项
     * @param by 要减少记(小于0)
     */
    public double hdecr( String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    //============================set=============================

    /**
     * 根据key获取Set中的所有值
     *
     * @param key 键
     */
    public Set<Object> sGet( String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key 键
     * @param value 值
     * @return true 存在 false不存在
     */
    public boolean sHasKey( String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将数据放入set缓存
     *
     * @param key 键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSet( String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 将set数据放入缓存
     *
     * @param key 键
     * @param time 时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSetAndTime( String key, long time, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0) {
                expire( key, time);
            }
            return count;
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取set缓存的长度
     *
     * @param key 键
     */
    public long sGetSetSize( String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 移除值为value的
     *
     * @param key 键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    public long setRemove( String key, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return 0;
        }
    }
    //===============================list=================================

    /**
     * 获取list缓存的内容
     *
     * @param key 键
     * @param start 开始
     * @param end 结束  0 到 -1代表所有值
     */
    public List<Object> lGet( String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取list缓存的长度
     *
     * @param key 键
     */
    public long lGetListSize( String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 通过索引 获取list中的值
     *
     * @param key 键
     * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     */
    public Object lGetIndex( String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key 键
     * @param value 值
     */
    public boolean lSet( String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key 键
     * @param value 值
     * @param time 时间(秒)
     */
    public boolean lSet( String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) {
                expire( key, time);
            }
            return true;
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key 键
     * @param value 值
     */
    public boolean lSet( String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);

            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key 键
     * @param value 值
     * @param time 时间(秒)
     */
    public boolean lSet( String key, List<Object> value, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0) {
                expire( key, time);
            }
            return true;
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据索引修改list中的某条数据
     *
     * @param key 键
     * @param index 索引
     * @param value 值
     */
    public boolean lUpdateIndex( String key, long index, Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除N个值为value
     *
     * @param key 键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    public long lRemove( String key, long count, Object value) {
        try {
            Long remove = redisTemplate.opsForList()
                .remove(key, count, value);
            return remove;
        } catch (Exception e) {
            logger.error("redis 操作失败，失败原因：", e);
            e.printStackTrace();
            return 0;
        }
    }


    /**
     * Object转成JSON数据
     */
    private String toJson(Object object) {
        if (object instanceof Integer || object instanceof Long || object instanceof Float ||
            object instanceof Double || object instanceof Boolean || object instanceof String) {
            return String.valueOf(object);
        }
        return GSON.toJson(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz) {
        return GSON.fromJson(json, clazz);
    }

    /**
     * 加锁
     *
     * @param value 当前时间+超时时间
     */
    public boolean lock(String key, String value) {
        //SETNX命令, 可以设置返回true, 不可以返回false
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }
        String currentValue = (String) redisTemplate.opsForValue().get(key);
        //如果锁过期
        if (!StringUtils.isEmpty(currentValue)
            && (Long.parseLong(currentValue) < System.currentTimeMillis())) {
            //GETSET命令, 获取上一个锁的时间
            String oldValue = (String) redisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁
     */
    public void unLock(String key, String value) {
        try {
            String currentValue = (String) redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue)
                && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            logger.error("【redis分布式锁】解锁异常, {}", e);
        }
    }




}
