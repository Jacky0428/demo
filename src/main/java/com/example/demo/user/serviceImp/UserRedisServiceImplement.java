package com.example.demo.user.serviceImp;

import com.example.demo.user.jpa.User;
import com.example.demo.user.service.UserRedisService;
import com.example.demo.utils.RedisOpsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRedisServiceImplement implements UserRedisService {
    @Autowired
    private RedisOpsUtils redisOpsUtils;

    @Override
    public void set(String account, User user) {
        redisOpsUtils.set(account, user);
    }

    @Override
    public Long rightPushObjToSpecList(String key, Object obj) {
        return redisOpsUtils.rightPushObjToSpecList(key, obj);
    }

    @Override
    public Object getDataByKey(String key) {
        return redisOpsUtils.getDataByKey(key);
    }

    @Override
    public boolean isExist(String key) {
        return redisOpsUtils.hasKey(key);
    }

}
