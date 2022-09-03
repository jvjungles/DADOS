package com.simulado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simulado.entity.Musica;
import com.simulado.entity.Pessoa;

public interface MusicaRepository extends JpaRepository<Musica, Long>{

	Musica findFirstBy();
	
	Musica findMusicaByTitulo(String musica);
}