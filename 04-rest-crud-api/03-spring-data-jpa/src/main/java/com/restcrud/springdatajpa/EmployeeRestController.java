package com.restcrud.springdatajpa;


import com.restcrud.springdatajpa.entity.Employee;
import com.restcrud.springdatajpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public boolean checkId(int id){
        return employeeService.getEmployee(id).isPresent();
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id){
        Optional<Employee> employee = employeeService.getEmployee(id);

        if(employee.isEmpty()){
            throw new RuntimeException("Employee not found--" + id);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        //making sure that we add employee not update
        employee.setId(0);
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        //throwing error when id == 0 to make sure we update and not add employee or if id is valid
        if(employee.getId() == 0 || !checkId(employee.getId())){
            throw new RuntimeException("Employee not found--");
        }

        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){

        if(!checkId(id)){
            throw new RuntimeException("Employee not found--" + id);
        }

        employeeService.deleteEmployee(id);
    }


}
