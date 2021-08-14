package com.vti.railway12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.railway12.entity.Clazz;

@Repository
public interface IClazzRepository extends JpaRepository<Clazz, Integer> {

	
}
