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


    public PostPreCoach(){
        System.out.println("Post Pre Coach: " + this.getClass().getSimpleName());
    }

    //init method runs after the constructor
    @PostConstruct
    public void init() {
        System.out.println("PostConstruct: " + this.getClass().getSimpleName());
    }

    //destroy method won't be called if scope is 'prototype'
    @PreDestroy
    public void predestroy() {
        System.out.println("PreDestroy: " + this.getClass().getSimpleName());
    }

}
