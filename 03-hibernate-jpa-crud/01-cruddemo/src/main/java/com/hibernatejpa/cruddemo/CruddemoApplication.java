package com.hibernatejpa.cruddemo;

import com.hibernatejpa.cruddemo.dao.StudentDAO;
import com.hibernatejpa.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {//Bean inject StudentDAO
        return _ -> deleteUser(studentDAO);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating multiple students ...");
        Student student1 = new Student("Name1", "Last", "email1@email.com");
        Student student2 = new Student("Name2", "Last", "email2@email.com");
        Student student3 = new Student("Name3", "Last", "email3@email.com");

        System.out.println("Saving students ...");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
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

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Reading student...");
        Student s1 = studentDAO.getStudentById(1);
        System.out.println(s1);
    }

    private void readAllStudents(StudentDAO studentDAO) {
        System.out.println("Reading all students...");
        List<Student> students = studentDAO.getAllStudents();
        System.out.println(students.size());
        System.out.println(students);
    }

    private void getAllByName(StudentDAO studentDAO) {
        System.out.println("Reading all students by name...");
        List<Student> students = studentDAO.getAllStudentsByName("Name", "Last");
        System.out.println(students.size());
        System.out.println(students);
    }

    private void updateStudent(StudentDAO studentDAO) {
        System.out.println("Updating student...");
        Student student = studentDAO.getStudentById(1);
        student.setFirstName("changed");
        student.setLastName("changed");
        studentDAO.update(student);
        System.out.println("Updated student, Generated id: " + student.getId());
        System.out.println(student);
    }

    private void deleteUser(StudentDAO studentDAO) {
        System.out.println("Deleting student...");
        Student student = studentDAO.getStudentById(1);
        if(student != null) {
            studentDAO.delete(1);
            System.out.println("deleted user");
        }else{
            System.out.println("user not found");
        }
    }
}
