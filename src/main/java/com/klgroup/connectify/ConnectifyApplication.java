package com.klgroup.connectify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.klgroup.connectify.controller"})
public class ConnectifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConnectifyApplication.class, args);
    }

}
