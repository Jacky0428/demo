package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Redis 相關操作集合
 */
@Component
public class RedisOpsUtils {

    /**
     * Spring 提供 Redis 基本操作套件
     */
    @Autowired
    RedisTemplate<Object, Object> redisTempPlate;

    /**
     * List 初始位置
     */
    private final Long indexStart = 0L;

    /**
     * String 型態，儲存一組資料
     * @param key Key
     * @param value 要儲存的物件
     */
    public void set(String key, Object value) {
        redisTempPlate.opsForValue().set(key, value);
    }

    /**
     * 在 List 最後方加入物件
     * @param key Key
     * @param obj 要儲存的物件
     * @return Long 為 List Size
     */
    public Long rightPushObjToSpecList(String key, Object obj) {
        ListOperations<Object, Object> listOps = redisTempPlate.opsForList();
        listOps.rightPush(key, obj);
        return listOps.size(key);
    }

    /**
     * 判斷在 Redis 內是否存在指定的 Key
     * @param key Key
     * @return boolean 判斷 Key 是否存在 Redis
     */
    public boolean hasKey(String key){
        return redisTempPlate.hasKey(key);
    }

    /**
     * 取的指定 Key 在 Redis 中的資料型態
     * @param key Key
     * @return DataType 取得 Key 的資料類型
     */
    public DataType getTypeOfKey(String key){
        return redisTempPlate.type(key);
    }

    /**
     * 依照 Key 取得資料
     * @param key Key
     * @return Object 依照類型取回資料
     */
    public Object getDataByKey(String key){
        DataType type = getTypeOfKey(key);
        switch (type){
            case LIST:
                return redisTempPlate.opsForList().range(key, indexStart, listSize(key));
            case SET:
                return redisTempPlate.opsForSet().members(key);
            case STRING:
                return redisTempPlate.opsForValue().get(key);
            case HASH:
                Map<Object, Object> entries = redisTempPlate.opsForHash().entries(key);
                return entries;
            case ZSET:
                return redisTempPlate.opsForZSet().zCard(key);
            case STREAM:
            case NONE:
            default:
                return null;
        }
    }

    /**
     * List Size
     * @param key Key
     * @return Size of List
     */
    private long listSize(String key) {
        return redisTempPlate.opsForList().size(key);
    }

    /**
     * 動態取得物件 Id
     * EmbeddedId 先跳過
     * @param obj 要取得 Id 的物件
     * @return Object 物件 Id
     */
    public Object getObjectId(Object obj){
        try{
            Field[] fields = obj.getClass().getDeclaredFields();;
            for (Field field : fields){
                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations){
                    if (annotation instanceof Id){
                        field.setAccessible(true);
                        return field.get(obj);
                    }else if (annotation instanceof EmbeddedId)
                        return null; // TODO
                }
            }
            return null;
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
