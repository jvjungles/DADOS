package com.simulado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simulado.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Categoria findFirstBy();
	
	Categoria findFirstByOrderByIdDesc();
	
	Categoria findByDescCategoria(String categoria);
}