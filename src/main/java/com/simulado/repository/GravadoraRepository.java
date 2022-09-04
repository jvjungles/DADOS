package com.simulado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simulado.entity.Gravadora;

@Repository
public interface GravadoraRepository extends JpaRepository<Gravadora, Long>{

	Gravadora findFirstBy();
	
	Gravadora findFirstByOrderByIdDesc();
	
	Gravadora findGravadoraByNomeGravadora(String gravadora);
}