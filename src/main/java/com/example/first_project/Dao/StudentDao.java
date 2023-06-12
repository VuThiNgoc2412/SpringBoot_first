package com.example.first_project.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.first_project.Mapper.StudentMapper;
import com.example.first_project.Model.StudentDto;


@Repository
public class StudentDao implements IStudentDao {
	@Autowired
	StudentMapper sm;
//	public void setSqlSessionFactory(@Qualifier("defaultDS") SqlSessionFactory sqlSessionFactory) {
//		super.setSqlSessionFactory(sqlSessionFactory);
//	}	

	public List<StudentDto> GetListStudent() {
		return sm.selectAll();
	}

	public int insert(StudentDto obj) {
		return sm.insertStudent(obj);

	}

	public void delete(String ID) {
		sm.deleteStudent(ID);;
	}
	public StudentDto findById(String ID) {
		return sm.findById(ID);
	}

	public void update(StudentDto obj) {
		sm.updateStudent(obj);
	}

	public List<StudentDto> findByName(String name) {
		return sm.findByName(name);
	}

	public StudentDto findByIdUser(String ID) {
		return sm.findByIdUser(ID);
	}

}
