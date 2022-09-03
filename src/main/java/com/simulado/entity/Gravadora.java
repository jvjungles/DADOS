package com.simulado.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "gravadora")
public class Gravadora extends AbstractPersistable<Long>{
	
	public Gravadora(String nome_gravadora, String pais) {
		super();
		this.nome_gravadora = nome_gravadora;
		this.pais = pais;
	}

	@Column(name = "nome_gravadora")
	private String nome_gravadora;
	
	@Column(name = "pais")
	private String pais;	

	@Override
	public void setId(Long cod_cantor) {
		super.setId(cod_cantor);
	}	

	public String getNome_gravadora() {
		return nome_gravadora;
	}
	
	public void setNome_gravadora(String nome_gravadora) {
		this.nome_gravadora = nome_gravadora;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}		
}