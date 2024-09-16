package com.core.qualifiers.imp;

import com.core.qualifiers.Coach;
import org.springframework.stereotype.Component;

@Component
public class TenisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "tenis coach";
    }
}
