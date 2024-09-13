package com.quickStart.myQucikStart.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestControler {

    // inject properties for: coach.name, team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // endpoint for "coachName"
    @GetMapping("/")
    public String sayHello() {
        return "say hello to " + coachName ;
    }

    // endpoint for "teamName"
    @GetMapping("/team/name")
    public String sayTeamName() {
        return teamName;
    }
}
