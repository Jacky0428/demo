package com.example.demo.service;

import com.example.demo.jpa.User;

public interface UserRedisService {
    void set(String account, User user);

    Long rightPushObjToSpecList(String key, Object obj);

    Object getDataByKey(String key);

    boolean isExist(String key);
}
