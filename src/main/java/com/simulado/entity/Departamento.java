package com.simulado.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "departamento")
public class Departamento extends AbstractPersistable<Long>{
	
    public Departamento() {
		super();
	}

	public Departamento(String nome_departamento) {
		super();
		this.nome_departamento = nome_departamento;
	}

	@Column(name = "nome_departamento")
	private String nome_departamento;    	

	@Override
	public void setId(Long id_departamento) {
		super.setId(id_departamento);
	}
    
	public String getNome_departamento() {
		return nome_departamento;
	}

	public void setNome_departamento(String nome_departamento) {
		this.nome_departamento = nome_departamento;
	}	

	@Override
	public String toString() {
		return "Departamento ["
				+ "\nnome_departamento=" + nome_departamento 
				+ "\n]";
	}	
}