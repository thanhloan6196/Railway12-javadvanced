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

import com.vti.railway12.entity.Position;
import com.vti.railway12.service.IPositionService;

@RestController
@RequestMapping("/position")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PositionController {

	@Autowired
	IPositionService positionService;
	
	@GetMapping("/position-list")
	ResponseEntity<List<Position>> getListPosition() {
		List<Position> listPosition = positionService.getAllPositions();
		return new ResponseEntity<List<Position>>(listPosition, HttpStatus.OK);
	}
	
	
	@GetMapping("/position/{id}")
	ResponseEntity<Position> getPositionById(Integer id){
		Position position = positionService.getPositionById(id);
		return new ResponseEntity<Position>(position, HttpStatus.OK);
	}
	
	@PostMapping("/create")
    public ResponseEntity<?> createPosition(@RequestBody Position position) {
		
		positionService.createPosition(position);
        return ResponseEntity.ok(("SUCCESS"));
    }
	
	@PostMapping("/update")
    public ResponseEntity<?> updatePosition(@RequestBody Position position) {
		positionService.updatePosition(position);
        return ResponseEntity.ok(("SUCCESS"));
    }
	
}
