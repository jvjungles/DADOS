package com.atividade07.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "funcionario")
@NamedQuery(
		   name = "Funcionario.byDependentes",
		   query = "from Funcionario f where f.qtdeDependente = ?1")
@NamedNativeQuery(
		   name = "Funcionario.byNomeLike",
		   query = "select f.* from funcionario f where f.nome_funcionario like :nomeFuncionario", 
		   resultClass = Funcionario.class)
@NamedStoredProcedureQuery( 
		   name = "Funcionario.aumentaSalario2",
		   procedureName = "proc_aumentaSalario2",
		   parameters = { 
		      @StoredProcedureParameter( 
		         mode = ParameterMode.IN, 
		         name = "arg",
		         type = Integer.class),
		      @StoredProcedureParameter(
		         mode = ParameterMode.OUT, 
		         name = "ret",
		         type = Funcionario.class)
		   })
public class Funcionario extends AbstractPersistable<Long>{
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(String nomeFuncionario) {
		super();
		this.nomeFuncionario = nomeFuncionario;		
	}

	public Funcionario(String nomeFuncionario, Integer qtdeDependente, 
			Double salario, String cargo, String cpf, Departamento departamento) {
		super();
		this.nomeFuncionario = nomeFuncionario;
		this.qtdeDependente = qtdeDependente;
		this.salario = salario;
		this.cargo = cargo;
		this.cpf = cpf;
		this.departamento = departamento;
	}	

	@Column(name="nome_funcionario")	
	private String nomeFuncionario;
	
	@Column(name="qtde_dependente")	
	private Integer qtdeDependente;
	
	@Column(name="salario")	
	private Double salario;
	
	@Column(name="cargo")	
	private String cargo;
	
	@Column(name="cpf", nullable = false)	
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name="id_departamento", nullable = false)	
	private Departamento departamento;
	
	@Override
	public void setId(Long id_funcionario) {
		super.setId(id_funcionario);
	}	

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}	

	public Integer getQtdeDependente() {
		return qtdeDependente;
	}

	public void setQtdeDependente(Integer qtdeDependente) {
		this.qtdeDependente = qtdeDependente;
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
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Funcionario ["
				+ "\nomeFuncionario= " 	 + nomeFuncionario 
				+ "\nqtdeDependente= "   + qtdeDependente
				+ "\nsalario= " 		 + salario 
				+ "\ncargo= " 			 + cargo
				+ "\ncpf= " 			 + cpf
				+ "\ndepartamento= " 	 + departamento 
				+ "\n]";
	}	
}