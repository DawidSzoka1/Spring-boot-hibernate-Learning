package com.quickStart.myQucikStart.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestControler {

    @GetMapping("/")
    public String sayHello() {
        return "Hello world!";
    }

}
