package com.vti.railway12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.DAO.DepartmentDAO;
import com.vti.railway12.entity.Department;

@Service
@Transactional
public class DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;
	
	public Department findById(int id) {
		return departmentDAO.findById(id);
	}

	public List<Department> findAll() {
		return departmentDAO.findAll();
	}
	
	public void save(Department department) {
		departmentDAO.save(department);
	}
	
	public void update(Department department) {
		departmentDAO.update(department);
	}
	
	public void delete(Department department) {
		departmentDAO.delete(department);
	}

}
