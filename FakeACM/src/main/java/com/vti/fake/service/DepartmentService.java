package com.vti.fake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.fake.entity.Department;
import com.vti.fake.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService{

	@Autowired
	IDepartmentRepository departmentRepository;
	@Override
	public List<Department> getListDepartment() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id).get();
	}

	@Override
	public void createDepartment(Department department) {
		departmentRepository.save(department);
		
	}

	@Override
	public void updateDepartment(Department department) {
		departmentRepository.save(department);
		
	}

	@Override
	public void deleteDepartment(int id) {
		departmentRepository.deleteById(id);
		
	}

}
