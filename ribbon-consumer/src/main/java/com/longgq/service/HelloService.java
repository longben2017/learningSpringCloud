package com.longgq.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by longgq on 7/10/18.
 */
@Service
public class HelloService {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback", commandKey = "helloKey")
    public String helloService() {
        long start = System.currentTimeMillis();

        Object result = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class);

        long end = System.currentTimeMillis();

        logger.info("spend time :" + (end - start));

        return result.toString();
    }

    private String helloFallback() {
        return "error";
    }
}
