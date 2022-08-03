package com.atividade05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.atividade05.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
