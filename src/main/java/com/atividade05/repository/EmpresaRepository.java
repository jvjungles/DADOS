package com.atividade05.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade05.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}