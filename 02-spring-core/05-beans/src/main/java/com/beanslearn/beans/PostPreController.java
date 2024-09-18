package com.beanslearn.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostPreController {
    private Coach coach;

    public PostPreController(@Qualifier("postPreCoach") Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/init")
    public String init() {
        return coach.getDailyWorkout();
    }
}
