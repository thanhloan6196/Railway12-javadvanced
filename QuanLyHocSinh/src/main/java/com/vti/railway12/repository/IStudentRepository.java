package com.vti.railway12.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vti.railway12.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByFirstName( String firstName);
	
	List<Student> findByLastName(String lastName);
	
	List<Student> findByEmail(String email);
	
	
	@Query("SELECT s FROM Student s WHERE "
			+ "(:firstName is null or s.firstName LIKE %:firstName%) and "
			+ "(:lastName is null or s.lastName LIKE %:lastName%) and "
			+ "(:email is null or s.email LIKE %:email%) and "
			+ "(:gender is null or LOWER(s.gender) = LOWER(:gender)) and "
			+ "(:address is null or s.address LIKE %:address% ) and"
			+ "(:classId is null or s.clazz.id = :classId)")

	Page<Student> findStudentByFirstNameAndLastNameAndEmailAndGenderAndAddressAndClass(
			@Param("firstName") String firstName,
			@Param("lastName") String lastName, 
			@Param("email") String email, 
			@Param("gender") String gender,
			@Param("address") String address,
			@Param("classId") Integer classId, 
			Pageable pageabe);
}
	

