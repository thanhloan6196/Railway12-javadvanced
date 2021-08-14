package com.vti.fake.service;

import java.util.List;

import com.vti.fake.entity.Department;

public interface IDepartmentService {

	List<Department> getListDepartment();
	
	Department getDepartmentById(int id);
	
	void createDepartment(Department department);
	
	void updateDepartment(Department department);
	
	void deleteDepartment(int id);
	
}
