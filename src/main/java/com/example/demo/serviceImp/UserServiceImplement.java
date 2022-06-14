package com.example.demo.serviceImp;

import com.example.demo.jpa.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public String addUser(String account, String pwd) {
        try{
            User newUser = new User();
            newUser.setAccount(account);
            newUser.setPassWord(pwd);
            repository.save(newUser);
            return "Success";
        }catch (Exception e){
            return e.getMessage();
        }
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
