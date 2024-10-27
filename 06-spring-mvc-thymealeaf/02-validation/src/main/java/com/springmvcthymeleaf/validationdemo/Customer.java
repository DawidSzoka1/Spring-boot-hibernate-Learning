package com.springmvcthymeleaf.validationdemo;

import com.springmvcthymeleaf.validationdemo.validation.CourseCode;
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
    private Integer value;

    @CourseCode(value = "code", message = "Must start with code")
    private String courseCode;

    public Customer() {
    }

    public Customer(String firstName,
                    String lastName,
                    @Min(value = 1) @Max(value = 10, message = "test 123")  Integer value,
                    String postCode,
                    String courseCode
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.value = value;
        this.postCode = postCode;
        this.courseCode = courseCode;
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


    public Integer getValue() {
        return value;
    }

    public void setValue(@Min(value = 0) @Max(value = 10, message = "setter error") Integer value) {
        this.value = value;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", value=" + value +
                ", postCode='" + postCode + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
