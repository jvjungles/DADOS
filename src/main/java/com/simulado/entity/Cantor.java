package com.simulado.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "cantor")
public class Cantor extends AbstractPersistable<Long>{
	

	@Column(name = "nome_cantor")
	private String nome_cantor;
	
	@Column(name = "pais")
	private String pais;	

	@Override
	public void setId(Long cod_cantor) {
		super.setId(cod_cantor);
	}

	public String getNome_cantor() {
		return nome_cantor;
	}

	public void setNome_cantor(String nome_cantor) {
		this.nome_cantor = nome_cantor;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}		
}