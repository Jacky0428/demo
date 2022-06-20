package com.example.demo.serviceImp;

import com.example.demo.jpa.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    UserRepository repository;

    @Transactional
    @Override
    public String addUser(String account, String pwd) {
        User newUser = new User();
        newUser.setAccount(account);
        newUser.setPassword(pwd);
        repository.save(newUser);
        return "Success";
    }

    @Override
    public User retrieveByAccount(String account) {
        return repository.findUserByAccount(account);
    }

    @Override
    public List<User> retrieveAll() {
        return repository.findAll();
    }
}
