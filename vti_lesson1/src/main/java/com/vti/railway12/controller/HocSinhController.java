package com.vti.railway12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.railway12.entity.HocSinh;
import com.vti.railway12.service.HocSinhService;


@RestController
@RequestMapping("/api")
public class HocSinhController {

	@Autowired
	  private HocSinhService hocSinhService;
	
	
	@GetMapping("/hoc-sinh-list")
	public List<HocSinh> getAllHocsinh() {
		return hocSinhService.findAll();
	}
	
	@GetMapping("hoc-sinh/{id}")
	public HocSinh getById(@PathVariable int id) {
		return hocSinhService.findById(id);
	}
	@PostMapping("/update")
	public void updateHocSinh(@RequestBody HocSinh hocSinh) {
		hocSinhService.updateHocSinh(hocSinh);
	}
	
	
}