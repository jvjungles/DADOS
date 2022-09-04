package com.simulado.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "gravadora")
public class Gravadora extends AbstractPersistable<Long>{	
	
	public Gravadora() {
		super();
	}

	public Gravadora(String nomeGravadora, String pais) {
		super();
		this.nomeGravadora = nomeGravadora;
		this.pais = pais;
	}

	@Column(name = "nome_gravadora")
	private String nomeGravadora;
	
	@Column(name = "pais")
	private String pais;	
	
	@OneToMany(mappedBy = "gravadora")
    private List<Gravacao> gravacoes;

	@Override
	public void setId(Long cod_cantor) {
		super.setId(cod_cantor);
	}	

	public String getNomeGravadora() {
		return nomeGravadora;
	}
	
	public void setNomeGravadora(String nomeGravadora) {
		this.nomeGravadora = nomeGravadora;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}	

	public List<Gravacao> getGravacoes() {
		return gravacoes;
	}

	public void setGravacoes(List<Gravacao> gravacoes) {
		this.gravacoes = gravacoes;
	}

	@Override
	public String toString() {
		return "Gravadora ["
				+ "nomeGravadora=" + nomeGravadora 
				+ ", pais=" + pais + "]";
	}
}