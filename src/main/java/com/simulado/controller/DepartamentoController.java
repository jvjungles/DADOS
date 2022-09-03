package com.simulado.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simulado.entity.Departamento;
import com.simulado.entity.Funcionario;
import com.simulado.exception.OperationException;
import com.simulado.service.DepartamentoService;

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
	public String create(String name) {	
		
		try {
			departamentoService.save(new Departamento(name));
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
	
	@ApiOperation(value = "Create Departamento and Funcionario", 
			  notes = "Method responsible for create Departamento and Funcionario")
	@PostMapping(value = "/create-departamentoAndFuncionario")
	@ResponseBody
	public String createDepartamentoAndFuncionario(String nomeDepartamento, 
			String nomeFuncionario, String cpfFuncionario, String cargoFuncionario, Integer qtde_dependenteFuncionario, Float salarioFuncionario) {		
		
		Departamento departamento = new Departamento();		
		departamento.setNome_departamento(nomeDepartamento);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNomeFuncionario(nomeFuncionario);
		funcionario.setCpf(cpfFuncionario);
		funcionario.setCargo(cargoFuncionario);
		funcionario.setQtdeDependente(qtde_dependenteFuncionario);
		funcionario.setSalario(salarioFuncionario.doubleValue());		

		try {
			departamentoService.saveDepartamentoAndFuncionario(departamento, funcionario);
			return "saved!!!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}