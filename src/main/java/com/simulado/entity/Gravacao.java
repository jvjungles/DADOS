package com.simulado.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "gravacao")
public class Gravacao extends AbstractPersistable<Long>{
	
	public Gravacao() {
		super();
	}

	public Gravacao(Date data_gravacao, Musica musica, Cantor cantor, Gravadora gravadora) {
		super();
		this.data_gravacao = data_gravacao;
		this.musica = musica;
		this.cantor = cantor;
		this.gravadora = gravadora;
	}

	@Column(name="data_gravacao", nullable = false)	
	private Date data_gravacao;	
	
	@ManyToOne
	@JoinColumn(name="cod_musica", nullable = false)	
	private Musica musica;
	
	@ManyToOne
	@JoinColumn(name="cod_cantor", nullable = false)	
	private Cantor cantor;
	
	@ManyToOne
	@JoinColumn(name="cod_gravadora", nullable = false)	
	private Gravadora gravadora;
	
	@Override
	public void setId(Long cod_gravacao) {
		super.setId(cod_gravacao);
	}

	public Date getData_gravacao() {
		return data_gravacao;
	}

	public void setData_gravacao(Date data_gravacao) {
		this.data_gravacao = data_gravacao;
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

	public Cantor getCantor() {
		return cantor;
	}

	public void setCantor(Cantor cantor) {
		this.cantor = cantor;
	}

	public Gravadora getGravadora() {
		return gravadora;
	}

	public void setGravadora(Gravadora gravadora) {
		this.gravadora = gravadora;
	}
}