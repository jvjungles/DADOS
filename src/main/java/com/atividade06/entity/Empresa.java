package com.atividade06.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "empresa")
public class Empresa extends AbstractPersistable<Long>{
	
    public Empresa() {
		super();
	}

	public Empresa(String nome_empresa) {
		super();
		this.nome_empresa = nome_empresa;
	}

	@Column(name = "nome_empresa")
	private String nome_empresa;
    
    @Override
	public void setId(Long id_empresa) {
		super.setId(id_empresa);
	}

	public String getNome_empresa() {
		return nome_empresa;
	}

	public void setNome_empresa(String nome_empresa) {
		this.nome_empresa = nome_empresa;
	}
	
	@Override
	public String toString() {
		return "Empresa ["
				+ "\nnome_empresa =" + nome_empresa 
				+ "\n]";
	}	
}