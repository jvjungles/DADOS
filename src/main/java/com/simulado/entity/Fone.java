package com.simulado.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "fone")
public class Fone extends AbstractPersistable<Long>{	
	
	public Fone() {
		super();
	}

	public Fone(String numero, String tipo, Pessoa pessoa) {
		super();
		this.numero = numero;
		this.tipo = tipo;
		this.pessoa = pessoa;
	}

	@Column(name="numero", nullable = false)	
	private String numero;
	
	@Column(name="tipo", nullable = false)	
	private String tipo;	
	
	@ManyToOne
	@JoinColumn(name="cod_pessoa", nullable = false)	
	private Pessoa pessoa;
	
	@Override
	public void setId(Long cod_fone) {
		super.setId(cod_fone);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Fone ["
				+ "numero=" + numero 
				+ "tipo=" + tipo 
				+ "pessoa=" + pessoa + "]";
	}
}