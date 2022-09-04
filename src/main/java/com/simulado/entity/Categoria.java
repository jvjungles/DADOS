package com.simulado.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "categoria")
public class Categoria extends AbstractPersistable<Long>{	
	
	public Categoria() {
		super();
	}

	public Categoria(String descCategoria) {
		super();
		this.descCategoria = descCategoria;
	}

	@Column(name = "desc_categoria")
	private String descCategoria;	
	
	@OneToMany(mappedBy = "categoria")
    private List<Musica> musicas;

	@Override
	public void setId(Long cod_categoria) {
		super.setId(cod_categoria);
	}

	public String getDescCategoria() {
		return descCategoria;
	}

	public void setDescCategoria(String descCategoria) {
		this.descCategoria = descCategoria;
	}	

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}	
	
	@Override
	public String toString() {
		return "Categoria [descCategoria=" + descCategoria + "]";
	}
}