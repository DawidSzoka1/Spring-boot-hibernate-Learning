package com.example.databaseproject.dao;

import com.example.databaseproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    public Optional<Student> findByEmail(String email);
    public List<Student> findAllByOrderByLastNameAsc();
}
