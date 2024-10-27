package com.springmvcthymeleaf.validationdemo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class Customer {

    @NotNull(message = "firstName not null")
    @Size(min = 1, max = 50, message = "firstName not null")
    private String firstName;

    @NotNull(message = "is required!")
    @Size(min=1, message = "is required!")
    private String lastName;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postCode;

    @Min(value = 0, message = "value must be greater or equal to zero")
    @Max(value = 10, message = "value must be lower or equal to ten")
    @NotNull(message = "is required!")
    private int value;

    public Customer() {
    }

    public Customer(String firstName,
                    String lastName,
                    @Min(value = 1) @Max(value = 10, message = "test 123")  int value,
                    String postCode
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.value = value;
        this.postCode = postCode;
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


    public int getValue() {
        return value;
    }

    public void setValue(@Min(value = 0) @Max(value = 10, message = "setter error") int value) {
        this.value = value;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", value=" + value +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
