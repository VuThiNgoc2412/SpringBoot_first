package com.example.first_project.Mapper;

import java.io.IOException;

import org.apache.ibatis.annotations.Mapper;

import com.example.first_project.Model.UserDto;
import com.example.first_project.Model.UserLogin;

@Mapper
public interface UserMapper {
	public int insertUser(UserDto obj);

	public UserDto checkIfUsernameOrEmailExists(UserLogin obj) throws IOException;

	public void update(UserDto obj);

	public String checkIfUsernameOrEmailExists(UserDto obj);

	public UserDto findUserByEmail(String email);

	public void delete(String id);

	public UserDto findUserById(String id);
}
