package com.quickStart.myQucikStart.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestControler {

    @Value("${coach.name}")
    private String coachName;

    @Value("${test}")
    private int test;

    @Value("${server.port}")
    private int port;

    @GetMapping("/{parem}/{one_more}/action/")
    public String sayHello(@PathVariable String parem, @PathVariable String one_more) {
        return "Hello world! " + coachName + " " + test + " port = " + port + " " + parem + one_more;
    }

}
