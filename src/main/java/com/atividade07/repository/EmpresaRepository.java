package com.atividade07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade07.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}