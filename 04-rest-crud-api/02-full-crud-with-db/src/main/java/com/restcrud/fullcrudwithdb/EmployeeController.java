package com.restcrud.fullcrudwithdb;


import com.restcrud.fullcrudwithdb.DAO.EmployeeDAO;
import com.restcrud.fullcrudwithdb.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeDAO.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeDAO.getEmployee(id);
    }
}
