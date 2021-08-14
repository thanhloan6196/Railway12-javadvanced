package com.vti.railway12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.railway12.entity.Clazz;
import com.vti.railway12.repository.IClazzRepository;

@Service
public class ClazzServiceImpl implements IClazzService{

	@Autowired
	IClazzRepository clazzRepository;
	
	@Override
	public List<Clazz> getAllClass() {
		
		return clazzRepository.findAll();

	}
}
