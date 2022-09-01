package com.atividade09.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade09.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

	Departamento findFirstBy();	
}