package com.example.demo.user.controller;


import com.example.demo.user.jpa.User;
import com.example.demo.user.service.UserRedisService;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User Api
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserRedisService userRedisService;

    @PostMapping("/add")
    public  String addUser(@RequestParam String account, @RequestParam String passWord){
        return userService.addUser(account, passWord);
    }

    @GetMapping("/retrieve")
    public User getUser(@RequestParam String account){
        User user = userService.retrieveByAccount(account);
        return user;
    }

    @GetMapping("/retrieveAll")
    public List<User> getUsers(){
        return userService.retrieveAll();
    }

    /**
     * 儲存物件到 Redis 並同時練習 RESTful風格
     */
    /**
     * 取得 User By Key
     * @param account 為 key
     * @return User 物件
     */
    @GetMapping("/tempUser/{account}")
    public User getByAccount(@PathVariable("account") String account){
        return (User) userRedisService.getDataByKey(account);
    }

    /**
     * 將物件儲存於 Redis String 結構
     * @param account 帳號
     * @param password 密碼
     * @return String of Info
     */
    @PostMapping("/tempUser/{account}/{password}")
    public String createUserToRedisString(@PathVariable("account") String account, @PathVariable("password") String password){
        User newUser = new User();
        newUser.setAccount(account);
        newUser.setPassword(password);
        if (userRedisService.isExist(account))
            return "Data Already Exist";
        userRedisService.set(account, newUser);
        return "Success";
    }

}
