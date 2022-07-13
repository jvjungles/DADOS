package pos.dados.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "departamento")
public class Departamento {
	
	public Departamento() {
		super();
	}	
	
	public Departamento(Integer cod_departamento) {
		super();
		this.cod_departamento = cod_departamento;
	}
	
	public Departamento(Integer cod_departamento, String nome_departamento) {
		super();
		this.cod_departamento = cod_departamento;
		this.nome_departamento = nome_departamento;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cod_departamento;
	private String nome_departamento;
	
	public Integer getCod_departamento() {
		return cod_departamento;
	}

	public void setCod_departamento(Integer cod_departamento) {
		this.cod_departamento = cod_departamento;
	}

	public String getNome_departamento() {
		return nome_departamento;
	}

	public void setNome_departamento(String nome_departamento) {
		this.nome_departamento = nome_departamento;
	}
}
