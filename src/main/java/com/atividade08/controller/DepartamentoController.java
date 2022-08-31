package com.atividade08.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atividade08.entity.Departamento;
import com.atividade08.entity.Empresa;
import com.atividade08.entity.Funcionario;
import com.atividade08.exception.OperationException;
import com.atividade08.service.DepartamentoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;

	@ApiOperation(value = "Create Departamento", 
				  notes = "Method responsible for create Departamento")
	@PostMapping(value = "/create")
	@ResponseBody
	public String create(String name, Long codEmpresa) {
		
		Empresa empresa = new Empresa();		
		empresa.setId(codEmpresa);
		
		try {
			departamentoService.save(new Departamento(name, empresa));
		} catch (OperationException e) {
			return e.getMessage();
		}
		return "Departamento succesfully created!!! \n\n";
	}

	@ApiOperation(value = "Delete Departamento by id", 
				  notes = "Method responsible for delete Departamento by id")
	@DeleteMapping(value = "/delete")
	@ResponseBody
	public String delete(Integer id) {

		try {
			departamentoService.delete(id);
		} catch (OperationException e) {
			return e.getMessage();
		}
		return "Departamento succesfully deleted!";
	}

	@ApiOperation(value = "Find Departamento by id", 
				  notes = "Method responsible for searching Departamento by id")
	@PostMapping(value = "/get-by-id")
	@ResponseBody
	public String getById(Integer id) {

		Optional<Departamento> departamento;
		try {
			departamento = departamentoService.getById(id);
			return departamento.get().toString();
		} catch (Exception e) {
			return "Departamento not found!";
		}
	}

	@ApiOperation(value = "Find All Departamentos", 
				  notes = "Method responsible for searching all Departamentos")
	@GetMapping(value = "/get-all")
	@ResponseBody
	public List<Departamento> getByAll() {

		try {
			return departamentoService.getAll();
		} catch (Exception e) {
			return null;
		}
	}
	
	@ApiOperation(value = "Find first Departamento", 
				  notes = "Method responsible for searching first Departamento")
	@GetMapping(value = "/get-first")
	@ResponseBody
	public String getFirst() {

		try {
			return departamentoService.findFirstBy().toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	//Atividade 08
	//Criar um método na classe de serviço de departamento para salvar um departamento, 
	//associar esse departamento a um funcionário e salvar esse funcionário em um mesmo controle de transação.
	
	@ApiOperation(value = "Find first Departamento", 
			  notes = "Method responsible for searching first Departamento")
	@PostMapping(value = "/create-departamentoAndFuncionario")
	@ResponseBody
	public String createDepartamentoAndFuncionario(Long codEmpresa, String nomeDepartamento, 
			String nome, String cpf, String cargo, Integer qtde_dependente, Float salario) {
		
		Empresa empresa = new Empresa();
		empresa.setId(codEmpresa);
		
		Departamento departamento = new Departamento();		
		departamento.setNome_departamento(nomeDepartamento);
		departamento.setEmpresa(empresa);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNomeFuncionario(nome);
		funcionario.setCpf(cpf);
		funcionario.setCargo(cargo);
		funcionario.setQtdeDependente(qtde_dependente);
		funcionario.setSalario(salario.doubleValue());		

		try {
			departamentoService.saveDepartamentoAndFuncionario(departamento, funcionario);
			return "saved!!!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}