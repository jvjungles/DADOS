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
	
	public Departamento(Long cod_departamento) {
		super();
		this.cod_departamento = cod_departamento;
	}
	
	public Departamento(Long cod_departamento, String nome_departamento) {
		super();
		this.cod_departamento = cod_departamento;
		this.nome_departamento = nome_departamento;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cod_departamento;
	private String nome_departamento;
	public Long getCod_departamento() {
		return cod_departamento;
	}

	public void setCod_departamento(Long cod_departamento) {
		this.cod_departamento = cod_departamento;
	}

	public String getNome_departamento() {
		return nome_departamento;
	}

	public void setNome_departamento(String nome_departamento) {
		this.nome_departamento = nome_departamento;
	}
}
