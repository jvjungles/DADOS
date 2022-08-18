package com.atividade07.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atividade07.entity.Departamento;
import com.atividade07.entity.Funcionario;
import com.atividade07.exception.OperationException;
import com.atividade07.service.FuncionarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@ApiOperation(value = "Proc Funcionarios Aumenta Salario", 
			notes = "Proc Funcionarios Aumenta Salario")
	@GetMapping(value = "/proc-aumentaSalario")
	@ResponseBody
	public List<Funcionario> getFuncionarioAumetaSalario(Integer arg) {
		
		try {
			return funcionarioService.getFuncionarioAumetaSalario(arg);
		} catch (Exception e) {
			return null;
		}		
	}

	@ApiOperation(value = "Create Funcionario", 
			notes = "Method responsible for create Funcionario")
	@PostMapping(value = "/create")
	public String create(String nome, String cpf, String cargo, 
			Integer qtde_dependente, Float salario, Long codDepartamento) {
		
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

	@ApiOperation(value = "Delete Funcionario by id", 
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
	
	@ApiOperation(value = "Find Funcionario by id", 
			notes = "Method responsible for searching Funcionario by id")
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
	
	@ApiOperation(value = "Find Funcionarios by nome", 
			notes = "Method responsible for searching Funcionarios by nome")
	@PostMapping(value = "/get-by-name")
	@ResponseBody
	public List<Funcionario> getByName(String nome) {
		
		try {
			return funcionarioService.findByName(nome);
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionarios by salario", 
			notes = "Method responsible for searching Funcionarios by salario")
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
	
	@ApiOperation(value = "Find Funcionarios by nome e qtde de dependentes", 
			notes = "Method responsible for searching Funcionarios by nome e qtde de dependentes")
	@PostMapping(value = "/get-by-nomeQtdeDependentes")
	@ResponseBody
	public List<Funcionario> getFuncionarioByNomeFuncionarioAndQtdeDependente(String name, Integer qtde_dependente) {
		
		try {
			return funcionarioService.findFuncionarioByNomeFuncionarioAndQtdeDependente(name, qtde_dependente);
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionarios by departamento", 
			notes = "Method responsible for searching Funcionarios by departamento")
	@PostMapping(value = "/get-by-departamento")
	@ResponseBody
	public List<Funcionario> getFuncionariosbyDepartamento(Integer id_departamento) {
		
		try {
			return funcionarioService.findFuncionariosbyDepartamento(id_departamento);
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find first Funcionario by maior salario", 
			notes = "Method responsible for searching first Funcionario by maior salario")
	@GetMapping(value = "/get-by-maiorSalario")
	@ResponseBody
	public Funcionario getFirstByOrderBySalarioDesc() {
		
		try {
			return funcionarioService.findFirstByOrderBySalarioDesc();
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find top 3 Funcionarios by maiores salarios", 
			notes = "Method responsible for searching the top 3 Funcionarios by maiores salarios")
	@GetMapping(value = "/get-by-tresMaioresSalario")
	@ResponseBody
	public List<Funcionario> getFirst3ByOrderBySalarioDesc() {
		
		try {
			return funcionarioService.findFirst3ByOrderBySalarioDesc();
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionario by sem dependentes", 
			notes = "Method responsible for searching Funcionario sem dependentes")
	@GetMapping(value = "/get-by-semDependentes")
	@ResponseBody
	public List<Funcionario> getFuncionarioByNDependents() {
		
		try {
			return funcionarioService.findFuncionarioByNoDependentes();
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionario by salario maior", 
			notes = "Method responsible for searching Funcionario by salario maior")
	@PostMapping(value = "/get-by-salarioMaior")
	@ResponseBody
	public List<Funcionario> getFuncionarioBySalarioValue(Double salario) {
		
		try {
			return funcionarioService.findFuncionarioBySalarioValue(salario);
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionario by salario maior nativeQuery", 
			notes = "Method responsible for searching Funcionario by salario maior nativeQuery")
	@PostMapping(value = "/get-by-salarioMaiorNq")
	@ResponseBody
	public List<Funcionario> getFuncionarioBySalarioValueNq(Double salario) {
		
		try {
			return funcionarioService.findFuncionarioBySalarioValueNq(salario);
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionario by dependentes namedQuery", 
			notes = "Method responsible for searching Funcionario by dependentes namedQuery")
	@PostMapping(value = "/get-by-dependentes")
	@ResponseBody
	public List<Funcionario> getByDependentes(Integer qtdeDependente) {
		
		try {
			return funcionarioService.findByDependentes(qtdeDependente);
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionario by name like namedNativeQuery", 
			notes = "Method responsible for searching Funcionario by name like namedNativeQuery")
	@PostMapping(value = "/get-by-nomeLike")
	@ResponseBody
	public List<Funcionario> findByNomeLike(String nome) {
		
		try {
			return funcionarioService.findByNomeLike(nome);
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionario by departamento e sem dependentes", 
			notes = "Method responsible for searching Funcionario by departamento e sem dependentes")
	@PostMapping(value = "/get-by-departamentoSemDependentes")
	@ResponseBody
	public List<Funcionario> getByDepartamentoSemDependentes(Integer departamento) {
		
		try {
			return funcionarioService.findByDepartamentoSemDependentes(departamento.longValue());
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Update Funcionario by departamento", 
			notes = "Method responsible for Updating Funcionario by departamento")
	@PostMapping(value = "/update-by-funcionariosDepartamento")
	@ResponseBody
	public List<Funcionario> updateAllFuncionariobyDepartamento(Integer departamentoDe, Integer departamentoPara) {
		
		try {
			return funcionarioService.updateAllFuncionariobyDepartamento(departamentoDe.longValue(), departamentoPara.longValue());
		} catch (Exception e) {
			return null;
		}		
	}
}