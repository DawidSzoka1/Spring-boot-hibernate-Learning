package com.injectionstart.injection;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout(){
        return "Cricket workout";
    }
}
