package com.vti.fake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vti.fake.entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer>{

	List<Account> findByEmail(String email);
	
	List<Account> findByUserName(String userName);
	
	@Query("SELECT a FROM Account a WHERE "
			+ "(:userName is null or a.userName LIKE %:username%) and"
			+ "(:fullName is null or a.fullName LIKE %:fullName%) and"
			+ "(:email is null or a.email LIKE %:email%) and"
			+ "(:departmentId is null or a.department.id = :departmentId) and"
			+ "(:positionId is null or a.position.id = :positionId)")
	
	List<Account> findAccounyByUserNameAndFullNameAndEmailAndDepartmentAndPosition(
			@Param("userName") String userName,
			@Param("fullName") String fullName,
			@Param("email") String email,
			@Param("departmentId") Integer departmentId,
			@Param("positionId") Integer positionId
			);
	
	
}
