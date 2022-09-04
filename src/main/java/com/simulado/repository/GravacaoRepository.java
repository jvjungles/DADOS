package com.simulado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simulado.entity.Gravacao;

@Repository
public interface GravacaoRepository extends JpaRepository<Gravacao, Long>{

	@Query(value = "select * from Gravacao where cod_cantor = ?1", nativeQuery = true)
	List<Gravacao> findGravacaoByCantorNq(Long cantorId);
	
	@Query("select g from Gravacao g"
	    	+ " where g.gravadora.id = :gravadora") 
	List<Gravacao> findGravacaoByGravadora(@Param("gravadora") Long gravadora);
}