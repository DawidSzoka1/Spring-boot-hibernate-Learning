package com.core.qualifiers.imp;

import com.core.qualifiers.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary//@Qualifier have higher priority
public class BaseballCoach  implements Coach {

    public BaseballCoach() {
        System.out.println("In constructor: " + getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "baseball coach";
    }
}
