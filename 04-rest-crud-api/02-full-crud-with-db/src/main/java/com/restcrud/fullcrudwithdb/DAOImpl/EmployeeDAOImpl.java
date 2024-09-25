package com.restcrud.fullcrudwithdb.DAOImpl;

import com.restcrud.fullcrudwithdb.DAO.EmployeeDAO;
import com.restcrud.fullcrudwithdb.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager em;

    @Autowired
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
    public Employee saveEmployee(Employee employee) {
        return em.merge(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        em.remove(em.find(Employee.class, id));
    }
}
