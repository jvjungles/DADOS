package com.atividade05.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atividade05.entity.Departamento;
import com.atividade05.entity.Funcionario;
import com.atividade05.exception.OperationException;
import com.atividade05.service.FuncionarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@ApiOperation(value = "Create Funcionario", notes = "Method responsible for create Funcionario")
	@PostMapping(value = "/create")
	public String create(String cargo, String nome, Integer qtde_dependente, Float salario, Long codDepartamento) {
		
		Funcionario funcionario = new Funcionario();
		Departamento departamento = new Departamento();
		
		funcionario.setCargo(cargo);
		funcionario.setNome_funcionario(nome);
		funcionario.setQtde_dependente(qtde_dependente);
		funcionario.setSalario(salario.doubleValue());		
		departamento.setId(codDepartamento);
		funcionario.setDepartamento(departamento);
		
		try {
			funcionarioService.save(funcionario);
		} catch (OperationException e) {
			return e.getMessage();
		}			
		
		return "Funcionario succesfully created!!! \n\n";
	}

	@ApiOperation(value = "Delete Funcionario by ID", notes = "Method responsible for delete Funcionario")
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
	
	@ApiOperation(value = "Find Funcionario by ID", notes = "Method responsible for searching Funcionario by ID")
	@PostMapping(value = "/get-by-id")
	@ResponseBody
	public String getById(Integer id) {
		
		Optional<Funcionario> funcionario;
		try {
			funcionario =  funcionarioService.getById(id);
			return "Funcionario is: " + funcionario.get().getNome_funcionario();
		} catch (Exception e) {
			return "Funcionario not found!";
		}
	}	
	
	@ApiOperation(value = "Find All Funcionarios", notes = "Method responsible for searching all Funcionarios")
	@GetMapping(value = "/get-all")
	@ResponseBody
	public List<Funcionario> getByAll() {
		
		try {
			return funcionarioService.getAll();
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionarios by Name", notes = "Method responsible for searching Funcionario by Name")
	@PostMapping(value = "/get-by-name")
	@ResponseBody
	public List<Funcionario> getByName(String nome) {
		
		try {
			return funcionarioService.findByName(nome);
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find Funcionarios by Salary", notes = "Method responsible for searching Funcionario by Salary")
	@PostMapping(value = "/get-by-salary")
	@ResponseBody
	public List<Funcionario> getBySalario(Double salario) {
		
		try {
			return funcionarioService.findBySalario(salario);
		} catch (Exception e) {
			return null;
		}		
	}
	
	@ApiOperation(value = "Find All Funcionarios by query", notes = "Method responsible for searching all Funcionarios by query")
	@GetMapping(value = "/get-all-query")
	@ResponseBody
	public List<Funcionario> getAllByQuery() {
		
		try {
			return funcionarioService.findAllByQuery();
		} catch (Exception e) {
			return null;
		}		
	}
}
