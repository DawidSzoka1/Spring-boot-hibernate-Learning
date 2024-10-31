package com.example.databaseproject.service;

import com.example.databaseproject.entity.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    Optional<Student> getStudentById(int id);
    List<Student> getAllStudents();
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
    Optional<Student> getStudentByEmail(String email);
}
