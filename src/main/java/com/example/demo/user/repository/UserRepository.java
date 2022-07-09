package com.example.demo.user.repository;


import com.example.demo.user.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.account = ?1")
    User findUserByAccount(String name);
}
