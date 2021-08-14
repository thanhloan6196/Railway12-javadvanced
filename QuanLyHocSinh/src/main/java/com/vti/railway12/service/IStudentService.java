package com.vti.railway12.service;

import org.springframework.data.domain.Page;

import com.vti.railway12.entity.Student;
import com.vti.railway12.form.FormSearchStudent;

public interface IStudentService {

	Page<Student> getAllStudent(int page, String collum);
	
	Student getStudentById(Integer id);
	
	void createStudent(Student student);
	
	void updateStudent(Student student);
	
	void deleteStudent(Student student);
	
	boolean isStudentExistByEmail(String email);
	
	boolean isStudentExistByFirstName(String firstName);
	
	boolean isStudentExistByLastName(String lastName);
	
	Page<Student> search(FormSearchStudent student);
}
