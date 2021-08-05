package com.vti.fake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.fake.entity.Position;
import com.vti.fake.repository.IPositionRepository;

@Service
public class PositionService implements IPositionService{

	@Autowired
	IPositionRepository positionRepository;
	
	@Override
	public List<Position> getListPosition() {
		// TODO Auto-generated method stub
		return positionRepository.findAll();
	}

	@Override
	public Position getPositionById(int id) {
		// TODO Auto-generated method stub
		return positionRepository.findById(id).get();
	}

}
