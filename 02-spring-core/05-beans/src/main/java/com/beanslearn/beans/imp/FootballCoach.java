package com.beanslearn.beans.imp;

import com.beanslearn.beans.Coach;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "football coach";
    }
}
