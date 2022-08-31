package com.atividade08.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade08.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

	Departamento findFirstBy();	
}