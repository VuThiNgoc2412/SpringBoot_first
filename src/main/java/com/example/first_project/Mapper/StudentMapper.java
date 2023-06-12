package com.example.first_project.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.first_project.Model.StudentDto;

@Mapper
public interface StudentMapper {
	List<StudentDto> selectAll();
	
	int insertStudent(StudentDto obj);
	
	List <StudentDto> findByName(String name);
	
	StudentDto findById(String ID);
	
	StudentDto findByIdUser(String ID);
	
	void deleteStudent(String ID);
	
	void updateStudent(StudentDto obj);
	
}
