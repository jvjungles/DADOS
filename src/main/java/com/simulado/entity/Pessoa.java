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

	public Pessoa(String nomePessoa) {
		super();
		this.nomePessoa = nomePessoa;
	}

	@Column(name = "nome_pessoa")
	private String nomePessoa;    	

	@Override
	public void setId(Long cod_pessoa) {
		super.setId(cod_pessoa);
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	@Override
	public String toString() {
		return "Pessoa [nomePessoa=" + nomePessoa + "]";
	}
}