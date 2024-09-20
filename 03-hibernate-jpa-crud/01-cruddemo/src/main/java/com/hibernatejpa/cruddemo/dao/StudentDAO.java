package com.hibernatejpa.cruddemo.dao;

import com.hibernatejpa.cruddemo.entity.Student;


public interface StudentDAO {
    void save(Student student);
    Student getStudentById(int id);
}
