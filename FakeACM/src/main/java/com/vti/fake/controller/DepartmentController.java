package com.vti.fake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.fake.entity.Department;
import com.vti.fake.service.IDepartmentService;

@RestController
@RequestMapping("/department")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DepartmentController {

	@Autowired
	IDepartmentService departmentService;
	
	@GetMapping("/department-list")
	ResponseEntity<List<Department>> getListDepartment(){
		List<Department> listDepartments = departmentService.getListDepartment();
		return new ResponseEntity<List<Department>>(listDepartments, HttpStatus.OK);
	}
	
	@GetMapping("/department/{id}")
	ResponseEntity<Department> getById(@PathVariable(name ="id") int id){
		return new ResponseEntity<Department>(departmentService.getDepartmentById(id), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	ResponseEntity<?> updateDepartment(@RequestBody Department department){
		departmentService.updateDepartment(department);
		return ResponseEntity.ok("Update thanh cong!");
		
	}
	
	@PostMapping("/create")
	ResponseEntity<?> createDepartment(@RequestBody Department department){
		departmentService.createDepartment(department);
		return ResponseEntity.ok("Success Creating!");
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<?> deleteById(@PathVariable(name = "id") int id){
		departmentService.deleteDepartment(id);
		return ResponseEntity.ok("Success delete!");
		
	}
}
