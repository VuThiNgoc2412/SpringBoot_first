package com.example.first_project.Config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.first_project.Mapper.UserMapper;
import com.example.first_project.Model.UserDto;

@Service
public class UserDetailService extends SqlSessionDaoSupport implements UserDetailsService{
	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDto user=userMapper.findUserById(username);
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found!");
		}
		return new UserPrincipal(user);
	}

}
