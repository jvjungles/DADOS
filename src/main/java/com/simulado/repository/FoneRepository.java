package com.simulado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simulado.entity.Fone;

public interface FoneRepository extends JpaRepository<Fone, Long>{

	Fone findFirstBy();
}