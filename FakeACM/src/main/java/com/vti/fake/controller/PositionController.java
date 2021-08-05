package com.vti.fake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.fake.entity.Position;
import com.vti.fake.service.IPositionService;

@RestController
@RequestMapping("/position")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PositionController {

	@Autowired
	IPositionService positionService;
	
	@GetMapping("/position-list")
	ResponseEntity<List<Position>> getAllPositions(){
		List<Position> listPositions = positionService.getListPosition();
		return new ResponseEntity<List<Position>>(listPositions, HttpStatus.OK);
	}
	
	@GetMapping("/position/{id}")
	ResponseEntity<Position> getPosbyId(@PathVariable(name ="id") int id){
		return new ResponseEntity<Position>(positionService.getPositionById(id), HttpStatus.OK);
	}
}
