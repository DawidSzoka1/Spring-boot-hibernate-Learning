package com.core.qualifiers.imp;

import com.core.qualifiers.Coach;
import org.springframework.stereotype.Component;


@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket coach";
    }
}
