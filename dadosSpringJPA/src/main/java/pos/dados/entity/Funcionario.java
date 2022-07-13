package pos.dados.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "funcionario")
public class Funcionario {
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(Integer cod_funcionario) {
		super();
		this.cod_funcionario = cod_funcionario;
	}
	
	public Funcionario(Integer cod_funcionario, String nome_funcionario, Integer qtde_dependente, Double salario,
			String cargo, Departamento departamento) {
		super();
		this.cod_funcionario = cod_funcionario;
		this.nome_funcionario = nome_funcionario;
		this.qtde_dependente = qtde_dependente;
		this.salario = salario;
		this.cargo = cargo;
		this.cod_departamento = departamento.getCod_departamento();
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cod_funcionario;
	private String nome_funcionario;
	private Integer qtde_dependente;
	private Double salario;
	private String cargo;
	private Integer cod_departamento;
	
	public Integer getCod_funcionario() {
		return cod_funcionario;
	}
	public void setCod_funcionario(Integer cod_funcionario) {
		this.cod_funcionario = cod_funcionario;
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
	public Integer getCod_departamento() {
		return cod_departamento;
	}
	public void setCod_departamento(Integer cod_departamento) {
		this.cod_departamento = cod_departamento;
	}

	@Override
	public String toString() {
		return "Funcionario [cod_funcionario=" + cod_funcionario + ", nome_funcionario=" + nome_funcionario
				+ ", qtde_dependente=" + qtde_dependente + ", salario=" + salario + ", cargo=" + cargo
				+ ", cod_departamento=" + cod_departamento + "]";
	}
}
