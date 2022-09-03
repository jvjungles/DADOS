package com.simulado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simulado.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Categoria findFirstBy();	
	
	Categoria findCategoriaByDesc_categoria(String categoria);
}