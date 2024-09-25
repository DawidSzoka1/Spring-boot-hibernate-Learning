package com.restcrud.fullcrudwithdb.DAOImpl;

import com.restcrud.fullcrudwithdb.DAO.EmployeeDAO;
import com.restcrud.fullcrudwithdb.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Controller
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager em;

    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return em.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public Employee getEmployee(int id) {
        return em.find(Employee.class, id);
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        em.persist(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        em.merge(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        em.remove(em.find(Employee.class, id));
    }
}
