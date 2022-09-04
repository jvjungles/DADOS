package com.simulado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simulado.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	Pessoa findFirstBy();
	
	Pessoa findFirstByOrderByIdDesc();
	
	Pessoa findPessoaByNomePessoa(String pessoa);
}