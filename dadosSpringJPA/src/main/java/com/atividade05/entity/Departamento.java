package com.atividade05.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "departamento")
public class Departamento extends AbstractPersistable<Long>{
	
    @Column(name = "nome_departamento")
	private String nome_departamento;

	@Override
	public void setId(Long id) {
		super.setId(id);;
	}
    
	public String getNome_departamento() {
		return nome_departamento;
	}

	public void setNome_departamento(String nome_departamento) {
		this.nome_departamento = nome_departamento;
	}

	@Override
	public String toString() {
		return "Departamento [nome_departamento=" + nome_departamento + "]";
	}	
}
