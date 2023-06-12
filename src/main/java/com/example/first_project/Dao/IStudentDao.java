package com.example.first_project.Dao;

import java.util.List;

import com.example.first_project.Model.StudentDto;



public interface IStudentDao {
	public List<StudentDto> GetListStudent();

	public int insert(StudentDto obj);
	
	public StudentDto findById(String ID);
	
	public StudentDto findByIdUser(String ID);
	
	public List<StudentDto> findByName(String name);

	public void update(StudentDto obj);
	
	public void delete(String ID);

}
