package com.vti.railway12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.railway12.entity.Question;
import com.vti.railway12.service.QuestionService;

@RestController
@RequestMapping("/question-api")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@GetMapping("/question-list")
	public List<Question> getAllQuestions() {
		return questionService.findAll();
	}

	@GetMapping("question/{id}")
	public Question getById(@PathVariable int id) {
		return questionService.findById(id);
	}

	@PostMapping("/update")
	public void update(@RequestBody Question question) {
		questionService.update(question);
	}

	@PostMapping("/create")
	public void createQuestion(@RequestBody Question question) {
		questionService.save(question);
	}
	
	@PostMapping("/delete")
	public void deleteQuestion(@RequestBody Question question) {
		questionService.delete(question);
	}
}
