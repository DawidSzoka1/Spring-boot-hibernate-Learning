package com.restcrud.springdatajpa.service;


import com.restcrud.springdatajpa.dao.EmployeeRepository;
import com.restcrud.springdatajpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployee(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        if (result.isEmpty()) {
            throw new RuntimeException("Employee not found");
        }
        return result;

    }

    @Override
    public Employee saveEmployee(Employee employee) {
        // if id == 0 then create otherwise update
        return employeeRepository.save(employee);
    }
    //JpaRepository provides @Transactional for us
    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
