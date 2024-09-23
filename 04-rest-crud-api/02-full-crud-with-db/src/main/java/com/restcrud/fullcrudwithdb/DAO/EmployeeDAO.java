package com.restcrud.fullcrudwithdb.DAO;

import com.restcrud.fullcrudwithdb.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();
    public Employee getEmployee(int id);
    public void addEmployee(Employee employee);
    public void updateEmployee(int id, Employee employee);
    public void deleteEmployee(int id);
}
