package com.hibernatejpa.cruddemo.dao;

import com.hibernatejpa.cruddemo.entity.Student;

import java.util.List;


public interface StudentDAO {
    void save(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudents();
    List<Student> getAllStudentsByName(String firstName, String lastName);
    void update(Student student);
    void delete(int id);
}
