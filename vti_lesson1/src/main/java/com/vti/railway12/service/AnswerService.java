package com.vti.railway12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.DAO.AnswerDAO;
import com.vti.railway12.entity.Answer;

@Service
@Transactional
public class AnswerService {
	
	@Autowired
	private AnswerDAO answerDAO;
	
	public Answer findById(int id) {
		return answerDAO.findById(id);
	}

	public List<Answer> findAll() {
		return answerDAO.findAll();
	}
	
	public void save(Answer answer) {
		answerDAO.save(answer);
	}

	public void update(Answer answer) {
		answerDAO.update(answer);
	}

	public void delete(Answer answer) {
		answerDAO.delete(answer);
	}

}
