package com.longgq.controller;

import com.longgq.entity.User;
import com.longgq.service.HelloApiService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloController implements HelloApiService {
    @Override
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @Override
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name,age);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ": " + user.getAge();
    }
}
