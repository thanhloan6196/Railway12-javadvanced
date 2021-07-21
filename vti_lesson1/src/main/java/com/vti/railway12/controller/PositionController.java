package com.vti.railway12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.railway12.entity.Position;
import com.vti.railway12.service.PositionService;

@RestController
@RequestMapping("/positionapi")
public class PositionController {

	@Autowired
	private PositionService positionService;

	@GetMapping("/position-list")
	public List<Position> getAllPosition() {
		return positionService.findAll();
	}

	@GetMapping("position/{id}")
	public Position getById(@PathVariable int id) {
		return positionService.findById(id);
	}

	@PostMapping("/update")
	public void updatePosition(@RequestBody Position position) {
		positionService.update(position);
	}
}
