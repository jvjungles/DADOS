package com.simulado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simulado.entity.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long>{

	Musica findFirstBy();
}