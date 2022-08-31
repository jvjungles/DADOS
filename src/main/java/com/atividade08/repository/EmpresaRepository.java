package com.atividade08.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade08.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}