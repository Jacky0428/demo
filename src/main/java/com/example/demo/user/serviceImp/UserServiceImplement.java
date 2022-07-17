package com.example.demo.user.serviceImp;

import com.example.demo.user.annotation.Log;
import com.example.demo.user.jpa.LoginStatus;
import com.example.demo.user.jpa.User;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

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
    @Log("Retrieve!!!!")
    public User retrieveByAccount(String account) {
        return repository.findUserByAccount(account);
    }

    @Override
    public List<User> retrieveAll() {
        return repository.findAll();
    }

    @Override
    public LoginStatus loggin(String account, String password){
        String afterEncode = passwordEncoder.encode(password);
        System.out.println(afterEncode);
        System.out.println(passwordEncoder.matches(password, afterEncode));

        return null;
    }


}
