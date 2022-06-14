package com.example.demo.controller;


import com.example.demo.jpa.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * User REST Api
 */


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    @ResponseBody
    public  String addUser(@RequestParam String account, @RequestParam String passWord){
        return userService.addUser(account, passWord);
    }

    @GetMapping("/retrieve")
    @ResponseBody
    public User getUser(@RequestParam String account){
        User user = userService.retrieveByAccount(account);
        return user;
    }

    @GetMapping("/retrieveAll")
    @ResponseBody
    public List<User> getUsers(){
        return userService.retrieveAll();
    }

//    @Autowired
//    UserRepository repository;
//
//    @PostMapping("/add")
//    @ResponseBody
//    public  String addUser(@RequestParam String account, @RequestParam String passWord){
//        User user = new User();
//        user.setAccount(account);
//        user.setPassWord(passWord);
//        user.setCreateDate(new Date());
//        repository.save(user);
//        return "Success";
//    }
//
//    @GetMapping("/retrieve")
//    @ResponseBody
//    public User getUser(@RequestParam String account){
//        User user = repository.findUserByAccount(account);
//        return user;
//    }
//
//    @GetMapping("/retrieveAll")
//    @ResponseBody
//    public List<User> getUsers(){
//        return repository.findAll();
//    }
}
