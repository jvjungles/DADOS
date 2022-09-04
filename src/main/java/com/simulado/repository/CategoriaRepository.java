package com.simulado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simulado.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Categoria findFirstBy();
	
	Categoria findFirstByOrderByIdDesc();
	
	List<Categoria> findByDescCategoria(String categoria);
}