package com.longgq.controller;

import com.longgq.entity.User;
import com.longgq.service.HelloService;
import com.longgq.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by longgq on 7/11/18.
 */
@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("longgq")).append("\n");
        sb.append(helloService.hello("longgq", 26)).append("\n");
        sb.append(helloService.hello(new User("longgq", 26))).append("\n");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET)
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("MIMI")).append("\n");
        sb.append(refactorHelloService.hello("MIMI",20)).append("\n");
        sb.append(refactorHelloService.hello(new User("MIMI",20))).append("\n");
        return sb.toString();
    }
}
