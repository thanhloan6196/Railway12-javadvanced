package com.vti.railway12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.railway12.entity.Answer;
import com.vti.railway12.service.AnswerService;

@RestController
@RequestMapping("/answerapi")
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@GetMapping("/answer-list")
	public List<Answer> getAllAccount() {
		return answerService.findAll();
	}

	@GetMapping("answer/{id}")
	public Answer getById(@PathVariable int id) {
		return answerService.findById(id);
	}

	@PostMapping("/update")
	public void updateAnswer(@RequestBody Answer answer) {
		answerService.update(answer);
	}

	@PostMapping("/create")
	public void createAnswer(@RequestBody Answer answer) {
		answerService.save(answer);
	}
	
	@PostMapping("/delete")
	public void deleteAnswer(@RequestBody Answer answer) {
		answerService.delete(answer);
	}

}
