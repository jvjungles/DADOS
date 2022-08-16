package com.atividade06.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atividade06.entity.Departamento;
import com.atividade06.entity.Funcionario;
import com.atividade06.exception.OperationException;
import com.atividade06.service.FuncionarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@ApiOperation(value = "Create Funcionario", 
			notes = "Method responsible for create Funcionario")
	@PostMapping(value = "/create")
	public String create(String nome, String cpf, String cargo, Integer qtde_dependente, Float salario, Long codDepartamento) {
		
		Departamento departamento = new Departamento();
		departamento.setId(codDepartamento);

		Funcionario funcionario = new Funcionario(nome, qtde_dependente, 
												  salario.doubleValue(), 
												  cargo, cpf, departamento);
		
		try {
			funcionarioService.save(funcionario);
		} catch (OperationException e) {
			return e.getMessage();
		}			
		
		return "Funcionario succesfully created!!! \n\n";
	}

	@ApiOperation(value = "Delete Funcionario by ID", 
			notes = "Method responsible for delete Funcionario")
	@DeleteMapping(value = "/delete")
	@ResponseBody
	public String delete(Integer id) {
		
		try {
			funcionarioService.delete(id);
		} catch (OperationException e) {
			return e.getMessage();
		}
		return "Funcionario succesfully deleted!";
	}
	
	@ApiOperation(value = "Find Funcionario by ID", 
			notes = "Method responsible for searching Funcionario by ID")
	@PostMapping(value = "/get-by-id")
	@ResponseBody
	public String getById(Integer id) {
		
		Optional<Funcionario> funcionario;
		try {
			funcionario =  funcionarioService.getById(id);
			return funcionario.get().toString();
		} catch (Exception e) {
			return "Funcionario not found!";
		}
	}	
	
	@ApiOperation(value = "Find All Funcionarios", 
			notes = "Method responsible for searching all Funcionarios")
	@GetMapping(value = "/get-all")
	@ResponseBody
	public List<Funcionario> getByAll() {
		
		try {
			return funcionarioService.getAll();
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionarios by Name", 
			notes = "Method responsible for searching Funcionarios by Name")
	@PostMapping(value = "/get-by-name")
	@ResponseBody
	public List<Funcionario> getByName(String nome) {
		
		try {
			return funcionarioService.findByName(nome);
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionarios by Salary", 
			notes = "Method responsible for searching Funcionarios by Salary")
	@PostMapping(value = "/get-by-salary")
	@ResponseBody
	public List<Funcionario> getBySalario(Double salario) {
		
		try {
			return funcionarioService.findBySalario(salario);
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find All Funcionarios by query", 
			notes = "Method responsible for searching all Funcionarios by query")
	@GetMapping(value = "/get-all-query")
	@ResponseBody
	public List<Funcionario> getAllByQuery() {
		
		try {
			return funcionarioService.findAllByQuery();
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionarios by Nome e Qtde dependentes", 
			notes = "Method responsible for searching Funcionarios by Nome e Qtde dependentes")
	@PostMapping(value = "/get-by-nomeQtdeDependentes")
	@ResponseBody
	public List<Funcionario> getFuncionarioByNomeFuncionarioAndQtdeDependente(String name, Integer qtde_dependente) {
		
		try {
			return funcionarioService.findFuncionarioByNomeFuncionarioAndQtdeDependente(name, qtde_dependente);
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionarios by Departamento", 
			notes = "Method responsible for searching Funcionarios by Departamento")
	@PostMapping(value = "/get-by-departamento")
	@ResponseBody
	public List<Funcionario> getFuncionariosbyDepartamento(Integer id_departamento) {
		
		try {
			return funcionarioService.findFuncionariosbyDepartamento(id_departamento);
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find first Funcionario by maior salary", 
			notes = "Method responsible for searching first Funcionario by maior salary")
	@GetMapping(value = "/get-by-maiorSalario")
	@ResponseBody
	public Funcionario getFirstByOrderBySalarioDesc() {
		
		try {
			return funcionarioService.findFirstByOrderBySalarioDesc();
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find first 3 Funcionario by maior salary", 
			notes = "Method responsible for searching first 3 Funcionario by maior salary")
	@GetMapping(value = "/get-by-tresMaiorSalario")
	@ResponseBody
	public List<Funcionario> getFirst3ByOrderBySalarioDesc() {
		
		try {
			return funcionarioService.findFirst3ByOrderBySalarioDesc();
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionario by no dependentes", 
			notes = "Method responsible for searching Funcionario no dependentes")
	@GetMapping(value = "/get-by-noDependentes")
	@ResponseBody
	public List<Funcionario> getFuncionarioByNoDependentes() {
		
		try {
			return funcionarioService.findFuncionarioByNoDependentes();
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionario by salario maior q", 
			notes = "Method responsible for searching Funcionario salario maior q")
	@GetMapping(value = "/get-by-salarioMaiorq")
	@ResponseBody
	public List<Funcionario> getFuncionarioBySalarioValue(Double salario) {
		
		try {
			return funcionarioService.findFuncionarioBySalarioValue(salario);
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionario by salario maior q nq", 
			notes = "Method responsible for searching Funcionario salario maior q nq")
	@GetMapping(value = "/get-by-salarioMaiorqNq")
	@ResponseBody
	public List<Funcionario> getFuncionarioBySalarioValueNq(Double salario) {
		
		try {
			return funcionarioService.findFuncionarioBySalarioValueNq(salario);
		} catch (Exception e) {
			return null;
		}		
	}
}