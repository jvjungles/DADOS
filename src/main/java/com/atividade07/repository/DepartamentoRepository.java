package com.atividade07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade07.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

	Departamento findFirstBy();	
}