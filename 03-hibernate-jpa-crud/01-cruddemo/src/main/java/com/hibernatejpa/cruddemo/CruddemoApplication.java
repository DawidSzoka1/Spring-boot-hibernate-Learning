package com.hibernatejpa.cruddemo;

import com.hibernatejpa.cruddemo.dao.StudentDAO;
import com.hibernatejpa.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {//Bean inject StudentDAO
        return _ -> createStudent(studentDAO);
    }

    private void createStudent(StudentDAO studentDAO) {

        // creating new student
        System.out.println("Creating student...");
        Student student = new Student("Name", "Last", "email@email.com");

        // save the student using DAO
        System.out.println("Saving student...");
        studentDAO.save(student);

        System.out.println("Saved student, Generated id: " + student.getId());
        System.out.println(student);

    }
}
