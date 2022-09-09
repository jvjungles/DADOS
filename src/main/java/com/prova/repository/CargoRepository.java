package com.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.entity.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{

	Cargo findFirstBy();
	
	Cargo findFirstByOrderByIdDesc();
}