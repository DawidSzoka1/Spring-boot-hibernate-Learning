package com.example.fullusersite.User;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class UserController {

    @GetMapping("/login")
    public String login(){
        return "login-form";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return "login-post";
    }

    @GetMapping("/register")
    public String register(){
        return "register-form";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        return "register-post";
    }

}
