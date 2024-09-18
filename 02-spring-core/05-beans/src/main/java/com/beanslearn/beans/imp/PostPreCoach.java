package com.beanslearn.beans.imp;

import com.beanslearn.beans.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PostPreCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "post pre coach";
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct: " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy: " + this.getClass().getSimpleName());
    }

}
