package com.vti.railway12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.DAO.GroupDAO;
import com.vti.railway12.entity.Group;

@Service
@Transactional
public class GroupService {

	@Autowired
	private GroupDAO groupDAO;
	
	public Group findById(int id) {
		return groupDAO.findById(id);
	}

	public List<Group> findAll() {
		return groupDAO.findAll();
	}
	
	public void save(Group group) {
		groupDAO.save(group);
	}

	public void update(Group group) {
		groupDAO.update(group);
	}

	public void delete(int id) {
		groupDAO.delete(id);
	}
}
