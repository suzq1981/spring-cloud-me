package com.badou.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BadouCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadouCloudGatewayApplication.class, args);
    }
}
