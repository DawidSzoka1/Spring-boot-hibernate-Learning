package com.core.qualifiers.imp;

import com.core.qualifiers.Coach;
import org.springframework.stereotype.Component;


@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Cricket coach";
    }
}
