package com.restcrud.usingdatabase.repository;

import com.restcrud.usingdatabase.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    private EntityManager em;

    @Autowired
    public RoleRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Role> findAll() {
        return em.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role findById(int id) {
        TypedQuery<Role> query = em.createQuery("from Role where id = :id", Role.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Role findByName(String name) {
        TypedQuery<Role> query = em.createQuery("from Role where name = :name", Role.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
