package com.badou.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BadouCloudOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadouCloudOrderApplication.class, args);
    }

}
