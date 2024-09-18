package com.core.qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;
    private final String qualifier = "baseballCoach";
    // constructor injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach")Coach coach) {
        //firs letter lower case then as in name of the class
        System.out.println("In constructor: " + getClass().getSimpleName());
        anotherCoach = coach;
    }

    //setter injection
    @Autowired
    public void setMyCoach(@Qualifier(qualifier) Coach myCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = myCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/second")
    public String second() {
        return anotherCoach.getDailyWorkout();
    }
}
