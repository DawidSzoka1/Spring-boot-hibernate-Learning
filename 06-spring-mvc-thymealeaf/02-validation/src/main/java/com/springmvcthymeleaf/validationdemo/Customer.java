package com.springmvcthymeleaf.validationdemo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {
    private String firstName;

    @NotNull(message = "is required!")
    @Size(min=2, max=50)
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

    public @NotNull @Size(min = 2, max = 50) String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull @Size(min = 2, max = 50) String lastName) {
        this.lastName = lastName;
    }
}
