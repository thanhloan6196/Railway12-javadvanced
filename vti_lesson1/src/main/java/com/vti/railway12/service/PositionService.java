package com.vti.railway12.service;


import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.DAO.PositionDAO;
import com.vti.railway12.entity.Position;

@Service
@Transactional
public class PositionService {

	@Autowired
	private PositionDAO positionDAO;
	
	public Position findById(int id) {
		return positionDAO.findById(id);
	}
	public List<Position> findAll() {
		return positionDAO.findAll();
	}
	
	public void save(Position position) {
		positionDAO.save(position);
	}

	public void update(Position position) {
		positionDAO.update(position);
	}

	public void delete(Position position) {
		positionDAO.delete(position);
	}
}
