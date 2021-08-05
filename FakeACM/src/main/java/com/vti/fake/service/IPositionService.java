package com.vti.fake.service;

import java.util.List;

import com.vti.fake.entity.Position;

public interface IPositionService {

	List<Position> getListPosition();
	
	Position getPositionById(int id);
	
}
