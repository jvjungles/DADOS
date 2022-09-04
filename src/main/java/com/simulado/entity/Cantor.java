package com.simulado.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "cantor")
public class Cantor extends AbstractPersistable<Long>{	
	
	public Cantor() {
		super();
	}

	public Cantor(String nomeCantor, String pais) {
		super();
		this.nomeCantor = nomeCantor;
		this.pais = pais;
	}

	@Column(name = "nome_cantor")
	private String nomeCantor;
	
	@Column(name = "pais")
	private String pais;
	
	@OneToMany(mappedBy = "cantor")
    private List<Gravacao> gravacoes;

	@Override
	public void setId(Long cod_cantor) {
		super.setId(cod_cantor);
	}	

	public String getNomeCantor() {
		return nomeCantor;
	}

	public void setNomeCantor(String nomeCantor) {
		this.nomeCantor = nomeCantor;
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
		return "Cantor ["
				+ "nomeCantor=" + nomeCantor 
				+ ", pais=" + pais + "]";
	}
}