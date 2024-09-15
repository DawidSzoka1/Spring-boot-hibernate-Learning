package com.injectionstart.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DailyWorkout {

    private final Coach coach;

    @Autowired
    public DailyWorkout(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return coach.getDailyWorkout();
    }
}
