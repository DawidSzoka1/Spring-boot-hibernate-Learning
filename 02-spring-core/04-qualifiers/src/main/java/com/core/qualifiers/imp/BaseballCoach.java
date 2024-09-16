package com.core.qualifiers.imp;

import com.core.qualifiers.Coach;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach  implements Coach {

    @Override
    public String getDailyWorkout() {
        return "baseball coach";
    }
}
