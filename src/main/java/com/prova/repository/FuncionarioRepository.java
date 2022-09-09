package com.prova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prova.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	Funcionario findFirstBy();
	
	Funcionario findFirstByOrderByIdDesc();
	
	@Query("select f.nome from Funcionario f order by nome")
	List<String> findFuncionariosOrderByNome();
	
	@Query("select count(f) from Funcionario f")
	Integer countFuncionarios();
}