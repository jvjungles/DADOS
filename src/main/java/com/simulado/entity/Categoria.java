package com.simulado.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "categoria")
public class Categoria extends AbstractPersistable<Long>{	

	@Column(name = "desc_categoria")
	private String desc_categoria;		

	@Override
	public void setId(Long cod_categoria) {
		super.setId(cod_categoria);
	}

	public String getDesc_categoria() {
		return desc_categoria;
	}

	public void setDesc_categoria(String desc_categoria) {
		this.desc_categoria = desc_categoria;
	}		
}