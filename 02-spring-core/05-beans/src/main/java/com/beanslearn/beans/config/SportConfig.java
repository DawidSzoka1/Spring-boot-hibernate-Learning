package com.beanslearn.beans.config;


import com.beanslearn.beans.Coach;
import com.beanslearn.beans.imp.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("customid")
    public Coach coachSwim(){
        return new SwimCoach();
    }
}
