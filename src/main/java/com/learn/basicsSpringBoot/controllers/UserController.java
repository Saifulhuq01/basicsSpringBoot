package com.learn.basicsSpringBoot.controllers;

import com.learn.basicsSpringBoot.model.user;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @GetMapping
    public List<user> getUsers(){
        return Arrays.asList(new user(1l,"sai@gmail.com","saifulhuq"),
                new user(2l,"john@gmail.com","john Doe"),
                new user(3l,"daerk@gmail.com","daerk"),
                new user(4l,"lisa@gmail.com","lisa")
                );

//        new user(2l,"daerk@gmail.com","daerk")
    }
}
