package com.restcrud.usingdao.dao;


import com.restcrud.usingdao.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
