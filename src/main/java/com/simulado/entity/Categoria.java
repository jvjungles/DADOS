package com.simulado.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	@Override
	public String toString() {
		return "Categoria [descCategoria=" + descCategoria + "]";
	}
}