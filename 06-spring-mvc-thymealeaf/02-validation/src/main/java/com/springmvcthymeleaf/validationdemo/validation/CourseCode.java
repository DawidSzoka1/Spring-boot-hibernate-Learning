package com.springmvcthymeleaf.validationdemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CurseCodeConstraintValidator.class)//logika tej adnotacji
@Target({ElementType.METHOD, ElementType.FIELD})// gdzie mozemy uzyc tej adnotacji
@Retention(RetentionPolicy.RUNTIME)//jak dlugo adnotacja bedzie ptzechowywana lub uzywana
public @interface CourseCode {

    public String value() default "luv";

    public String message() default "Must start with luv";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

}
