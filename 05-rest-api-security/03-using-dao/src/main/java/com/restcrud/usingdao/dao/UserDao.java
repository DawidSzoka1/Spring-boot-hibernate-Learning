package com.restcrud.usingdao.dao;


import com.restcrud.usingdao.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
}
