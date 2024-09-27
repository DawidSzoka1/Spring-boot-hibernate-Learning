package com.restcrud.usingdatabase.repository;


import com.restcrud.usingdatabase.entity.Role;

import java.util.List;

public interface RoleRepository {
    List<Role> findAll();
    Role findById(int id);
    Role findByName(String name);
}
