//package pos.dados.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Entity
//@Data
//@Table(name = "funcionario")
//public class Funcionario {	
//
//	public Funcionario(Long cod_funcionario, String nome_funcionario, Integer qtde_dependente, Double salario,
//			String cargo, Departamento departamento) {
//		super();
//		this.cod_funcionario = cod_funcionario;
//		this.nome_funcionario = nome_funcionario;
//		this.qtde_dependente = qtde_dependente;
//		this.salario = salario;
//		this.cargo = cargo;
//		this.departamento = departamento;
//	}
//	
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long cod_funcionario;
//	private String nome_funcionario;
//	private Integer qtde_dependente;
//	private Double salario;
//	private String cargo;
//	private Departamento departamento;
//	
//
//}
