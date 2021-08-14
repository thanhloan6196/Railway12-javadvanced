package com.vti.railway12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.railway12.entity.Department;
import com.vti.railway12.service.IDepartmentService;

@RestController
@RequestMapping("/department")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DepartmentController {
	
	@Autowired
	IDepartmentService departmentService;
	
	@GetMapping("/department-list")
	ResponseEntity<List<Department>> getListDepartment() {
		List<Department> listDepartment = departmentService.getAllDepartments();
		return new ResponseEntity<List<Department>>(listDepartment, HttpStatus.OK);
	}
	
	@PostMapping("/create")
    public ResponseEntity<?> createDepartment(@RequestBody Department department) {
		
		departmentService.createDepartment(department);
        return ResponseEntity.ok(("SUCCESS CREATE"));
    }
	
	@PostMapping("/update")
    public ResponseEntity<?> updateDepartment(@RequestBody Department department) {
		
		departmentService.updateDepartment(department);
        return ResponseEntity.ok(("SUCCESS UPDATE"));
    }

}
