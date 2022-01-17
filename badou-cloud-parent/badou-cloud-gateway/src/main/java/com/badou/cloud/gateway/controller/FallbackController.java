package com.badou.cloud.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/fallbackHystrix")
    public String fallbackHystrix(){
        return "fallbackHystrix error";
    }

    @RequestMapping("/fallbackCircuitBreaker")
    public String fallbackCircuitBreaker(){
        return "fallbackCircuitBreaker error";
    }
}
