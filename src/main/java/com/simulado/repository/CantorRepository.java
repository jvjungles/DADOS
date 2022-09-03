package com.simulado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simulado.entity.Cantor;

public interface CantorRepository extends JpaRepository<Cantor, Long>{

	Cantor findFirstBy();	
	
	Cantor findByNomeCantor(String cantor);
}