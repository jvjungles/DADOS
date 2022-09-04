package com.simulado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simulado.entity.Gravacao;

@Repository
public interface GravacaoRepository extends JpaRepository<Gravacao, Long>{

	Gravacao findFirstBy();
}