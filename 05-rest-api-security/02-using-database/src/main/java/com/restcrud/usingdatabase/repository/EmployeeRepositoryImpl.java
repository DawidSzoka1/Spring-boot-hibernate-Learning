package com.restcrud.usingdatabase.repository;

import com.restcrud.usingdatabase.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private EntityManager em;

    @Autowired
    public EmployeeRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Employee findByEmployeeEmail(String email) {
        TypedQuery<Employee> query = em.createQuery("from Employee where email=:email", Employee.class);
        query.setParameter("email", email);
        Employee employee = null;
        try {
            employee = query.getSingleResult();
        }catch (Exception _) {

        }
        return employee;
    }

    @Override
    public Optional<Employee> findById(int id) {
        TypedQuery<Employee> query = em.createQuery("from Employee where id=:id", Employee.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Employee> findAll() {

        return em.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return em.merge(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        em.remove(em.find(Employee.class, id));
    }
}
