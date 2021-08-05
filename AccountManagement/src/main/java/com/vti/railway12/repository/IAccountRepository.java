package com.vti.railway12.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vti.railway12.entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {

	List<Account> findByEmail(String email);

	List<Account> findByUserName(String userName);

	@Query("SELECT a FROM Account a WHERE "
			+ "(:userName is null or a.userName LIKE %:userName%) and "
			+ "(:email is null or a.email LIKE %:email%) and "
			+ "(:fullName is null or a.fullName LIKE %:fullName%) and "
			+ "(:positionID is null or a.position.id = :positionID) and "
			+ "(:departmentID is null or a.department.id = :departmentID)")

	Page<Account> findAccountByUserNameAndEmailAndFullNameAndPositionAndDepartment(
			@Param("userName") String userName,
			@Param("email") String email, 
			@Param("fullName") String fullName, 
			@Param("positionID") Long positionID,
			@Param("departmentID") Long departmentID, 
			Pageable pageabe);
}
