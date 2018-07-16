package com.longgq.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends HelloApiService {


}
