package com.vti.railway12.service;

import java.util.List;

import com.vti.railway12.entity.Position;

public interface IPositionService {

	List<Position> getAllPositions();
	
	Position getPositionById(int id);
	
	void createPosition(Position position);
	
	void updatePosition(Position position);
	
	void deletePosition(Position position);
}
