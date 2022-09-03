package com.simulado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simulado.entity.Gravacao;

public interface GravacaoRepository extends JpaRepository<Gravacao, Long>{

	Gravacao findFirstBy();
}