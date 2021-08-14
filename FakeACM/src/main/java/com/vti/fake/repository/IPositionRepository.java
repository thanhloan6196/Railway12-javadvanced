package com.vti.fake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.fake.entity.Position;

@Repository
public interface IPositionRepository extends JpaRepository<Position, Integer>{

}
