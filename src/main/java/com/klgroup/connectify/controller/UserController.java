package com.klgroup.connectify.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Api
public class UserController {

    @GetMapping("/hello")
    public String login(){
        return "hello";
    }
}
