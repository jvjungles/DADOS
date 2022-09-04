package com.simulado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simulado.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	Pessoa findFirstBy();
	
	Pessoa findFirstByOrderByIdDesc();
	
	@Query("select p from Pessoa p")
	List<Pessoa> findAllByQuery();
}