package com.vti.railway12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.DAO.ExamDAO;
import com.vti.railway12.entity.Exam;

@Service
@Transactional
public class ExamService {

	@Autowired
	private ExamDAO examDAO;
	
	public Exam findById(int id) {
		return examDAO.findById(id);
	}

	public List<Exam> findAll() {
		return examDAO.findAll();
	}
	
	public void save(Exam exam) {
		examDAO.save(exam);
	}

	public void update(Exam exam) {
		examDAO.update(exam);;
	}

	public void delete(Exam exam) {
		examDAO.delete(exam);
	}
}
