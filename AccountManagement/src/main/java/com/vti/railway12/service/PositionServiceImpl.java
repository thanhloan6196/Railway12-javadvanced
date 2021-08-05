package com.vti.railway12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.railway12.entity.Position;
import com.vti.railway12.repository.IPositionRepositpry;

@Service
public class PositionServiceImpl implements IPositionService{

	@Autowired
	IPositionRepositpry positionRepository;
	
	@Override
	public List<Position> getAllPositions() {
		// TODO Auto-generated method stub
		return positionRepository.findAll();
	}

	@Override
	public Position getPositionById(int id) {
		// TODO Auto-generated method stub
		return positionRepository.findById(id).get();
	}

	@Override
	public void createPosition(Position position) {
		positionRepository.save(position);
		
	}

	@Override
	public void updatePosition(Position position) {
		positionRepository.save(position);
		
	}

	@Override
	public void deletePosition(Position position) {
		positionRepository.delete(position);
		
	}

}
