package com.restcrud.usingdatabase.repository;

import com.restcrud.usingdatabase.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
