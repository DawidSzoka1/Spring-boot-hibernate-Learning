package com.hibernatejpa.cruddemo.daoimp;

import com.hibernatejpa.cruddemo.dao.StudentDAO;
import com.hibernatejpa.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


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

    @Override
    public List<Student> getAllStudents() {
        return entityManager.createQuery("FROM Student", Student.class).getResultList();
    }

    @Override
    public List<Student> getAllStudentsByName(String firstName, String lastName) {
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student WHERE firstName like :first and lastName like :last",
                Student.class
        );
        query.setParameter("first", firstName).setParameter("last", lastName);

        return query.getResultList();
    }
}
