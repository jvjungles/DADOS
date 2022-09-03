package com.simulado.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "pessoa")
public class Pessoa extends AbstractPersistable<Long>{
	
    public Pessoa() {
		super();
	}

	public Pessoa(String nome_pessoa) {
		super();
		this.nome_pessoa = nome_pessoa;
	}

	@Column(name = "nome_pessoa")
	private String nome_pessoa;    	

	@Override
	public void setId(Long cod_pessoa) {
		super.setId(cod_pessoa);
	}

	public String getNome_pessoa() {
		return nome_pessoa;
	}

	public void setNome_pessoa(String nome_pessoa) {
		this.nome_pessoa = nome_pessoa;
	}
		
}