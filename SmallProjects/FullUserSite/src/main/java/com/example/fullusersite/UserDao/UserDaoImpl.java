package com.example.fullusersite.UserDao;

import com.example.fullusersite.User.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager em;

    public UserDaoImpl() {}

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public User findByUsername(String username) {
        Query query = em.createQuery("select u from User u where u.name = :username");
        query.setParameter("username", username);

        return new User();
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }


}
