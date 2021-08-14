package com.vti.railway12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.railway12.entity.Department;
import com.vti.railway12.service.DepartmentService;

@RestController
@RequestMapping("/deptapi")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/dept-list")
	public List<Department> getAllDepartments() {
		return departmentService.findAll();
	}

	@GetMapping("dept/{id}")
	public Department getById(@PathVariable int id) {
		return departmentService.findById(id);
	}
	
	@PutMapping("/update")
	public void updateDepartment(@RequestBody Department department) {
		departmentService.update(department);
	}
	
	@PostMapping("/create")
	public void createDepartment(@RequestBody Department department) {
		departmentService.save(department);
	}
	
	@PostMapping("/delete")
	public void deleteDepartment(@RequestBody Department department) {
		departmentService.delete(department);
	}
}
