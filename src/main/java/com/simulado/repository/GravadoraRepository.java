package com.simulado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simulado.entity.Gravadora;

public interface GravadoraRepository extends JpaRepository<Gravadora, Long>{

	Gravadora findFirstBy();
	
	Gravadora findFirstByOrderByIdDesc();
	
	Gravadora findGravadoraByNomeGravadora(String gravadora);
}