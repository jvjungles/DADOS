package com.simulado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simulado.entity.Cantor;

@Repository
public interface CantorRepository extends JpaRepository<Cantor, Long>{

	Cantor findFirstBy();
	
	Cantor findFirstByOrderByIdDesc();
	
	List<Cantor> findByNomeCantor(String cantor);
}