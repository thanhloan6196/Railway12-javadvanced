package com.vti.railway12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.railway12.entity.Department;
import com.vti.railway12.repository.IDepartmentRepository;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	IDepartmentRepository DepartmentRepository;
	
	@Override
	public List<Department> getAllDepartments() {
		
		return DepartmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(int id) {
		
		return DepartmentRepository.findById(id).get();
	}

	@Override
	public void createDepartment(Department department) {
		DepartmentRepository.save(department);
		
	}

	@Override
	public void updateDepartment(Department department) {
		DepartmentRepository.save(department);
		
	}

	@Override
	public void deleteDepartment(Department department) {
		DepartmentRepository.delete(department);
		
	}

}
