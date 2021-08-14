package com.vti.fake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.fake.entity.Department;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Integer>{

}
