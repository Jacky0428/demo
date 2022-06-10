package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 建立一個 Controller (API Service)
 * test url: http://localhost:8080/hello
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String handle01(){
        return "Hello, Spring Boot 2! Seth commit Test!";
    }

    /**
     * 重新導向首頁
     *
     * @param response
     * @throws IOException
     */
    @GetMapping("/index")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://localhost:8080/index.html");
    }

    @GetMapping("/sayHi")
    public String sayHi(@RequestParam(value = "name", defaultValue = "Stranger")String name){
        return String.format("Hi welcome : %s", name);
    }
}
