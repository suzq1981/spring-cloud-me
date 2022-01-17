package com.badou.cloud.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.validation.constraints.Digits;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class BadouCloudAdminApplication {


    public static void main(String[] args) {
        SpringApplication.run(BadouCloudAdminApplication.class, args);
    }

}
