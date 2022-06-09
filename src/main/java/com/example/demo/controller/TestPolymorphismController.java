package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.web.bind.annotation.*;

/**
 * 測試多形
 * url: localhost:8080/testPolymorphism
 * type: POST
 * param: {
 *     "id": 1,
 *     "name": "小白",
 *     "color": "紅色",
 *     "age": 3,
 *     "type": "Dog"
 * }
 * PS：type 可以換成 Cat
 */
@RestController
public class TestPolymorphismController {
    @PostMapping("/testPolymorphism")
    @ResponseBody
    public Animal testPolymorphism(@RequestBody Animal a){
        return a;
    }
}

/**
 * 抽象類別，並給定有兩個子類別
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Dog.class, name = "Dog"),
        @JsonSubTypes.Type(value=Cat.class, name = "Cat")
})
abstract class Animal {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Dog extends Animal{
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}

class Cat extends Animal{
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}