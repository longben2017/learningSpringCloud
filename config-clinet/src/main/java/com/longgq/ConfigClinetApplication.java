package com.longgq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ConfigClinetApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClinetApplication.class).web(true).run(args);
    }
}
