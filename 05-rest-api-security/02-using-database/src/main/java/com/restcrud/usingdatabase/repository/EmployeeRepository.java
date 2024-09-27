package com.restcrud.usingdatabase.repository;

import com.restcrud.usingdatabase.entity.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeRepository {
    Employee findByEmployeeEmail(String email);
    Optional<Employee> findById(int id);
    List<Employee> findAll();
    Employee save(Employee employee);
    void deleteById(int id);
}
