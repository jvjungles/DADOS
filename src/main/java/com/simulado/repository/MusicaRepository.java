package com.simulado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simulado.entity.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long>{

	Musica findFirstBy();
	
	Musica findFirstByOrderByIdDesc();
	
	Musica findMusicaByTitulo(String musica);
	
	@Query(name = "Musica.byTituloLike")
	List<Musica> findByTituloLike(@Param("titulo") String titulo);
}