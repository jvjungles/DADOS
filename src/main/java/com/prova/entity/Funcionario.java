package com.prova.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "funcionario")
public class Funcionario extends AbstractPersistable<Long>{	
	   

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "telefone")
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name="IDCargoFK", nullable = false)	
	private Cargo cargo;		

	@Override
	public void setId(Long cod_pessoa) {
		super.setId(cod_pessoa);
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}	
}