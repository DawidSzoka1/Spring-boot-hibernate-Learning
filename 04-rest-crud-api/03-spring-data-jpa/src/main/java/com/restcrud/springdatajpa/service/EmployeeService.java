package com.restcrud.springdatajpa.service;

import com.restcrud.springdatajpa.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployee(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(int id);
}
