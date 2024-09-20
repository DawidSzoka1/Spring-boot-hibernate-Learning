package com.hibernatejpa.cruddemo.daoimp;

import com.hibernatejpa.cruddemo.dao.StudentDAO;
import com.hibernatejpa.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Repository//sub class of Component
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional//only if we performe some update in database
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student getStudentById(int id) {
        return entityManager.find(Student.class, id);//if not find return null
    }
}
