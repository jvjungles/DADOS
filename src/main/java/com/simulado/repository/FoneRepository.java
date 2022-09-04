package com.simulado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simulado.entity.Fone;

@Repository
public interface FoneRepository extends JpaRepository<Fone, Long>{

	Fone findFirstBy();
	
	List<Fone> findByNumero(String numero);
}