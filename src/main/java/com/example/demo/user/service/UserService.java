package com.example.demo.user.service;

import com.example.demo.user.jpa.LoginStatus;
import com.example.demo.user.jpa.User;

import java.util.List;



public interface UserService  {

    String addUser(String account, String pwd);

    User retrieveByAccount(String account);

    List<User> retrieveAll();

    LoginStatus loggin(String account, String password);
}
