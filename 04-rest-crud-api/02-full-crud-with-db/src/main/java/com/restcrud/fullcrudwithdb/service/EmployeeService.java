package com.restcrud.fullcrudwithdb.service;

import com.restcrud.fullcrudwithdb.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployee(int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
