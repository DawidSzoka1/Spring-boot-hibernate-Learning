package com.core.qualifiers.imp;

import com.core.qualifiers.Coach;
import org.springframework.stereotype.Component;

@Component
public class TenisCoach implements Coach {

    public TenisCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "tenis coach";
    }
}
