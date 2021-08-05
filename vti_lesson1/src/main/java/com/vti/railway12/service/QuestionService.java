package com.vti.railway12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.DAO.QuestionDAO;
import com.vti.railway12.entity.Question;

@Service
@Transactional
public class QuestionService {

	@Autowired
	private QuestionDAO questionDAO;
	
	public Question findById(int id) {
		return questionDAO.findById(id);
	}

	public List<Question> findAll() {
		return questionDAO.findAll();
	}
	
	public void save(Question question) {
		questionDAO.save(question);
	}

	public void update(Question question) {
		questionDAO.update(question);;
	}

	public void delete(Question question) {
		questionDAO.delete(question);
	}
}
