package com.example.demo.service;

import com.example.demo.jpa.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;



public interface UserService  {

    String addUser(String account, String pwd);

    User retrieveByAccount(String account);

    List<User> retrieveAll();
}
