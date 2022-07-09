package com.example.demo.user.service;

import com.example.demo.user.jpa.User;

public interface UserRedisService {
    void set(String account, User user);

    Long rightPushObjToSpecList(String key, Object obj);

    Object getDataByKey(String key);

    boolean isExist(String key);
}
