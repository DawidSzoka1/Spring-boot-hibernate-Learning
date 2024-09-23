package com.restcrud.fullcrudwithdb.DAOImpl;

import com.restcrud.fullcrudwithdb.DAO.EmployeeDAO;
import com.restcrud.fullcrudwithdb.entity.Employee;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    @Override
    public Employee getEmployee(int id) {
        return null;
    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public void updateEmployee(int id, Employee employee) {

    }

    @Override
    public void deleteEmployee(int id) {

    }
}
