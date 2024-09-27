package com.restcrud.usingdatabase.service;

import com.restcrud.usingdatabase.entity.Employee;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface EmployeeService extends UserDetailsService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee findByEmail(String email);
    Employee save(Employee employee);
    void deleteById(int id);

}
