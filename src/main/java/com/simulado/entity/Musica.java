package com.simulado.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "musica")
public class Musica extends AbstractPersistable<Long>{	
	
	public Musica() {
		super();
	}

	public Musica(String titulo, Integer duracao, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.duracao = duracao;
		this.categoria = categoria;
	}

	@Column(name="titulo", nullable = false)	
	private String titulo;
	
	@Column(name="duracao", nullable = false)	
	private Integer duracao;	
	
	@ManyToOne
	@JoinColumn(name="cod_categoria", nullable = false)	
	private Categoria categoria;
	
	@OneToMany(mappedBy = "musica")
    private List<Gravacao> gravacoes;
	
	@Override
	public void setId(Long cod_musica) {
		super.setId(cod_musica);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}	

	public List<Gravacao> getGravacoes() {
		return gravacoes;
	}

	public void setGravacoes(List<Gravacao> gravacoes) {
		this.gravacoes = gravacoes;
	}

	@Override
	public String toString() {
		return "Musica ["
				+ "titulo=" + titulo 
				+ ", duracao=" + duracao 
				+ ", categoria=" + categoria + "]";
	}
}