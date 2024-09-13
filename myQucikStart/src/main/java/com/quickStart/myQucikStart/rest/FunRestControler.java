package com.quickStart.myQucikStart.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestControler {

    @Value("${coach.name}")
    private String coachName;

    @Value("${test}")
    private int test;

    @Value("${server.port}")
    private int port;

    @GetMapping("/")
    public String sayHello() {
        return "Hello world! " + coachName + " " + test + " port = " + port;
    }

}
