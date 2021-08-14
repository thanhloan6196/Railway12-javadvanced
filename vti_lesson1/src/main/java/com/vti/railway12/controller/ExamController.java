package com.vti.railway12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.railway12.entity.Exam;
import com.vti.railway12.service.ExamService;

@RestController
@RequestMapping("/examapi")
public class ExamController {

	@Autowired
	private ExamService examService;

	@GetMapping("/exam-list")
	public List<Exam> getAllExams() {
		return examService.findAll();
	}

	@GetMapping("exam/{id}")
	public Exam getById(@PathVariable int id) {
		return examService.findById(id);
	}

	@PostMapping("/update")
	public void update(@RequestBody Exam exam) {
		examService.update(exam);
	}

	@PostMapping("/create")
	public void createExam(@RequestBody Exam exam) {
		examService.save(exam);
	}
}
