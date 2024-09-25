package com.restcrud.fullcrudwithdb.DAO;

import com.restcrud.fullcrudwithdb.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    Employee getEmployee(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(int id);
}
