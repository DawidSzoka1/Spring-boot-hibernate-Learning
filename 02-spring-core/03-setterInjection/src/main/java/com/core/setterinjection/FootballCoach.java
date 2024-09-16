package com.core.setterinjection;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootballCoach implements Coach {


    @Override
    public String getDailyWorkout() {
        return "football coach";
    }
}
