package com.vti.railway12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vti.railway12.entity.Student;
import com.vti.railway12.form.FormSearchStudent;
import com.vti.railway12.repository.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentRepository studentRepository;
	
	@Value("${account.page.recordTotals}")
    private int totalRecords;
	
	@Override
	public Page<Student> getAllStudent(int page, String collum) {
		Pageable pageable =  PageRequest.of(page, totalRecords, Sort.by(collum));
		return studentRepository.findAll(pageable);
	}

	@Override
	public Student getStudentById(Integer id) {
		
		return studentRepository.findById(id).get();
	}

	@Override
	public void createStudent(Student student) {
		
		studentRepository.save(student);
			
	}

	@Override
	public void updateStudent(Student student) {
		Student studentUpdate = studentRepository.findById(student.getId()).get();
		studentUpdate.setFirstName(student.getFirstName());
		studentUpdate.setLastName(student.getLastName());
		studentUpdate.setEmail(student.getEmail());
		studentUpdate.setGender(student.getGender());
		studentUpdate.setAddress(student.getAddress());
		studentUpdate.setClazz(student.getClazz());
		
		studentRepository.save(studentUpdate);
		
	}

	@Override
	public void deleteStudent(Student student) {
		studentRepository.delete(student);
		
	}

	@Override
	public boolean isStudentExistByEmail(String email) {
		List<Student> listStudent = studentRepository.findByEmail(email);
		if(listStudent.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isStudentExistByFirstName(String firstName) {
		List<Student> listStudent = studentRepository.findByFirstName(firstName);
		if(listStudent.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isStudentExistByLastName(String lastName) {
		List<Student> listStudent = studentRepository.findByLastName(lastName);
		if(listStudent.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Page<Student> search(FormSearchStudent student) {
		Pageable pageable = PageRequest.of(student.getPage(), totalRecords, Sort.by("id"));
		return studentRepository.findStudentByFirstNameAndLastNameAndEmailAndGenderAndAddressAndClass(
				student.getFirstName(), 
				student.getLastName(), 
				student.getEmail(), 
				student.getGender(), 
				student.getAddress(), 
				student.getClassId(), 
				pageable);
	}
	

}
