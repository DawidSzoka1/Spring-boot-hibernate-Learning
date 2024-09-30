package com.springmvcthymeleaf.validationdemo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

    @NotNull(message = "firstName not null")
    @Size(min = 1, max = 50, message = "firstName not null")
    private String firstName;

    @NotNull(message = "is required!")
    @Size(min=1, message = "is required!")
    private String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
