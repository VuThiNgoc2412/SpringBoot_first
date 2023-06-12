package com.example.first_project.Dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.first_project.Mapper.UserMapper;
import com.example.first_project.Model.UserDto;
import com.example.first_project.Model.UserLogin;


@Repository
public class UserDao implements IUserDao {
	@Autowired
	UserMapper userMapper;

	public int register(UserDto obj) {
		return userMapper.insertUser(obj);
		
	}

	
	public UserDto validateLogin(UserLogin obj) throws IOException {
		return userMapper.checkIfUsernameOrEmailExists(obj);
	}

	public void update(UserDto obj) {
	}

	public List<UserDto> getUserByUsername(String username) {
//		String sql = "select * from user where username=?";
//		return _jdbcTemplate.queryForObject(sql, new UserMapper(), new Object[] { username });
		/*List<UserDto> listUser = new ArrayList<UserDto>();
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		listUser = session.selectList("UserDao.getUserByUsername", username);
		session.commit();
		session.close();*/
		return null;
	}

	public String validateReigister(UserDto obj) {
//		int count = _jdbcTemplate.queryForObject("select count(*) from user where username=?", Integer.class,
//				obj.getUsername());
//		if (count == 1) {
//			return "Error username";
//		}
//		count = _jdbcTemplate.queryForObject("select count(*) from user where email=?", Integer.class, obj.getEmail());
//		if (count == 1) {
//			return "Error email";
//		}
//		return "true";
		return userMapper.checkIfUsernameOrEmailExists(obj);
	}
	public static void main(String[] args) throws IOException {
//		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
//		//@SuppressWarnings("unchecked")
//		List<UserDto> userDtoList = session.selectList("selectAll");
//		session.commit();
//		session.close();
////		return userDtoList;
//		System.out.println(userDtoList);
		
        /*UserDto userDto = null;
		
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("username", "ngale");
		paramMap.put("pass", "123");
		
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		userDto = session.selectOne("UserDao.selectUsernameAndPass", paramMap);
		session.commit();
		session.close();
		System.out.println(userDto);*/
    }


	@Override
	public UserDto findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		userMapper.delete(id);
		
	}

	public UserDto findUserById(String id) {
		return userMapper.findUserById(id);
	}


	
}
