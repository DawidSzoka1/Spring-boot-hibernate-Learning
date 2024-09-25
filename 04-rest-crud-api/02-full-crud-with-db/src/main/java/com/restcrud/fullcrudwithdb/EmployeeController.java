package com.restcrud.fullcrudwithdb;

import com.restcrud.fullcrudwithdb.entity.Employee;
import com.restcrud.fullcrudwithdb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);

        if(employee == null){
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
        //throwing error when id == 0 to make sure we update and not add employee
        if(employee.getId() == 0){
            throw new RuntimeException("Employee not found--");
        }

        //making sure that the employee exists
        Employee employee1 = employeeService.getEmployee(employee.getId());
        if(employee1 == null){
            throw new RuntimeException("Employee not found--" + employee.getId());
        }
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);

        if(employee == null){
            throw new RuntimeException("Employee not found--" + id);
        }

        employeeService.deleteEmployee(id);
    }

}
