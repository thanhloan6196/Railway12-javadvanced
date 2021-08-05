package com.vti.railway12.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.railway12.entity.Student;
import com.vti.railway12.form.FormSearchStudent;
import com.vti.railway12.service.IStudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class StudentController {

	@Autowired
	IStudentService studentService;
	
	@GetMapping("/student-list")
	ResponseEntity<Page<Student>> getListStudent(@RequestParam int page, @RequestParam String collum){
		Page<Student> listStudent = studentService.getAllStudent(page, collum);
		return new ResponseEntity<Page<Student>>(listStudent, HttpStatus.OK);
	}
	
	@PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody @Valid Student student, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()) {
			throw new Exception(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		
		boolean isExistEmail = studentService.isStudentExistByEmail(student.getEmail());
		if(isExistEmail) {
			return ResponseEntity.ok(("EMAIL"));
		}
		
		boolean isExistFirstName = studentService.isStudentExistByFirstName(student.getFirstName());
		if(isExistFirstName) {
			return ResponseEntity.ok(("FIRSTNAME"));
		}
		
		boolean isExistLastName = studentService.isStudentExistByLastName(student.getLastName());
		if(isExistLastName) {
			return ResponseEntity.ok(("LASTNAME"));
		}
		
		studentService.createStudent(student);
        return ResponseEntity.ok(("Them moi thanh cong hoc sinh " + student.getFirstName() + " " + student.getLastName()));
    }
	
	@PostMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody @Valid Student student ,BindingResult bindingResult ) throws Exception {
		if(bindingResult.hasErrors()) {
			throw new Exception(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		Student studentUpdate = studentService.getStudentById(student.getId());
		
		// Kiem tra email da ton tai hay chua
		if(!studentUpdate.getEmail().equals(student.getEmail())) {
			boolean isExistEmail = studentService.isStudentExistByEmail(student.getEmail());
			if(isExistEmail) {
				return ResponseEntity.ok(("EMAIL"));
			}
		}
		
		// kiem tra first name da ton tai hay chua
		if(!studentUpdate.getFirstName().equals(student.getFirstName())) {
			boolean isExistFirstName = studentService.isStudentExistByFirstName(student.getFirstName());
			if(isExistFirstName) {
				return ResponseEntity.ok(("FIRSTNAME"));
			}
		}
		
		// kiem tra last name da ton tai hay chua
		if(!studentUpdate.getLastName().equals(student.getLastName())) {
			boolean isExistLastName = studentService.isStudentExistByLastName(student.getLastName());
			if(isExistLastName) {
				return ResponseEntity.ok(("LASTNAME"));
			}
		}
		
			
		studentService.updateStudent(student);
        return ResponseEntity.ok(("Sua thanh cong hoc sinh " + student.getFirstName() + " " + student.getLastName()));
    }	
	
	
	@PostMapping("/delete")
    public ResponseEntity<?> deleteStudent(@RequestBody Student student) {
		String firstName = studentService.getStudentById(student.getId()).getFirstName();
		String lastName = studentService.getStudentById(student.getId()).getLastName();
		studentService.deleteStudent(student);
        return ResponseEntity.ok(("Xoa thanh cong hoc sinh "+ firstName + " " + lastName ));
    }
	
	@PostMapping("/search")
	public ResponseEntity<?> searchStudent(@RequestBody FormSearchStudent student) {
		Page<Student> listStudent = studentService.search(student);
		return new ResponseEntity<Page<Student>>(listStudent, HttpStatus.OK);
	}
	
}
