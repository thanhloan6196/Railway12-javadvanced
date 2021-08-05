package com.vti.railway12.service;

import java.util.List;

import com.vti.railway12.entity.Department;

public interface IDepartmentService {


	List<Department> getAllDepartments();
	
	Department getDepartmentById(int id);
	
	void createDepartment(Department department);
	
	void updateDepartment(Department department);
	
	void deleteDepartment(Department department);
}
