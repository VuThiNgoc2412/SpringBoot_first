package com.example.first_project.Dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.first_project.Mapper.UserRoleMapper;
import com.example.first_project.Model.UserRoleDto;


@Repository
public class UserRoleDao implements IUserRoleDao {

	@Autowired
	UserRoleMapper userRoleMapper;
	
	public void insert(UserRoleDto obj) {
		 userRoleMapper.insert(obj);
	}
	
	public UserRoleDto findByIdUser(String id) {
		return userRoleMapper.findByIdUser(id);
	}

	public void delete(String id) {
		userRoleMapper.delete(id);
	}

}
