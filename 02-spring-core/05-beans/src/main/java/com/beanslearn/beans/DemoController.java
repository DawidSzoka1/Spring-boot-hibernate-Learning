package com.beanslearn.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach coach,
            @Qualifier("cricketCoach") Coach anotherCoach
    ) {
        myCoach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/check")
    public String getWorkout() {
        return "Comparing two beans: myCoach == anotherCoach: " + (myCoach == anotherCoach);
    }

}