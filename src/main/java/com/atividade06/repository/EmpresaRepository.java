package com.atividade06.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade06.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}