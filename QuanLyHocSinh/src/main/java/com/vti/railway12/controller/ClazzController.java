package com.vti.railway12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.railway12.entity.Clazz;
import com.vti.railway12.service.IClazzService;



@RestController
@RequestMapping("/class")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ClazzController {

	@Autowired
	IClazzService classService;
	
	@GetMapping("/class-list")
	ResponseEntity<List<Clazz>> getListClass() {
		List<Clazz> listClasses = classService.getAllClass();
		return new ResponseEntity<List<Clazz>>(listClasses, HttpStatus.OK);
	}
}
