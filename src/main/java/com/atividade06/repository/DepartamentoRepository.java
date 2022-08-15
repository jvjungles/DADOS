package com.atividade06.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade06.entity.Departamento;
import com.atividade06.entity.Funcionario;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

	Departamento findFirstBy();
	
}