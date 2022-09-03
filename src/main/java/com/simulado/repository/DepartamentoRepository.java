package com.simulado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simulado.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

	Departamento findFirstBy();	
}