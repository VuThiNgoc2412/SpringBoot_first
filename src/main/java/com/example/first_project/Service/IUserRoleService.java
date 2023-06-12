package com.example.first_project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_project.Model.UserRoleDto;


@Service
public interface IUserRoleService {
	
	@Autowired
	public void insert(UserRoleDto obj);
	
	@Autowired
	public UserRoleDto findByIdUser(String id);
	
	@Autowired
	public void delete(String id);
}
