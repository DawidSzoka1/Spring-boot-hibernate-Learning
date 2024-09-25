package com.restcrud.fullcrudwithdb.service;

import com.restcrud.fullcrudwithdb.DAO.EmployeeDAO;
import com.restcrud.fullcrudwithdb.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;


    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);

    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
