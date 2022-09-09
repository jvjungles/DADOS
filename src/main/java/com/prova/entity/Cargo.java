package com.prova.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "cargo")
public class Cargo extends AbstractPersistable<Long>{	
	
	public Cargo() {
		super();
	}

	public Cargo(String cargo) {
		super();
		this.cargo = cargo;
	}

	@Column(name="cargo", nullable = false)	
	private String cargo;
	
	@OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;
	
	@Override
	public void setId(Long IDCagoPK) {
		super.setId(IDCagoPK);
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public String toString() {
		return "Cargo [cargo=" + cargo + "]";
	}
}