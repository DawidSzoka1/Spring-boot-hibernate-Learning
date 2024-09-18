package com.beanslearn.beans.imp;

import com.beanslearn.beans.Coach;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//new object instance for each injection
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "cricket coach";
    }
}
