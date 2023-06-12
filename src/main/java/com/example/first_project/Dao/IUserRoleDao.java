package com.example.first_project.Dao;

import org.springframework.stereotype.Repository;

import com.example.first_project.Model.UserRoleDto;


@Repository
public interface IUserRoleDao {

	public void insert(UserRoleDto obj);
	
	public UserRoleDto findByIdUser(String id);
	
	public void delete(String id);
}
