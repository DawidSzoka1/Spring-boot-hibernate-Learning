package com.beanslearn.beans.imp;

import com.beanslearn.beans.Coach;

public class SwimCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Swim coach";
    }
}
