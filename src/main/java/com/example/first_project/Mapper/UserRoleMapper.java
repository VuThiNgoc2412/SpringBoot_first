package com.example.first_project.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.first_project.Model.UserRoleDto;

@Mapper
public interface UserRoleMapper {
    public void insert(UserRoleDto obj);
	
	public UserRoleDto findByIdUser(String id);
	
	public void delete(String id);
}
