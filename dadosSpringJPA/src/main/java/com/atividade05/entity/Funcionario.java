package com.atividade05.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "funcionario")
public class Funcionario extends AbstractPersistable<Long>{
	
	@Column(name="nome_funcionario")	
	private String nome_funcionario;
	
	@Column(name="qtde_dependente")	
	private Integer qtde_dependente;
	
	@Column(name="salario")	
	private Double salario;
	
	@Column(name="cargo")	
	private String cargo;
	
	@ManyToOne
	@JoinColumn(name="id_departamento", nullable = false)	
	private Departamento departamento;
	
	@Override
	public void setId(Long id) {
		super.setId(id);;
	}

	public String getNome_funcionario() {
		return nome_funcionario;
	}

	public void setNome_funcionario(String nome_funcionario) {
		this.nome_funcionario = nome_funcionario;
	}

	public Integer getQtde_dependente() {
		return qtde_dependente;
	}

	public void setQtde_dependente(Integer qtde_dependente) {
		this.qtde_dependente = qtde_dependente;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Funcionario [nome_funcionario=" + nome_funcionario + ", qtde_dependente=" + qtde_dependente
				+ ", salario=" + salario + ", cargo=" + cargo + ", departamento=" + departamento + "]";
	}	
}
