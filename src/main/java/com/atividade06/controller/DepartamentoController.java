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
import com.atividade06.entity.Empresa;
import com.atividade06.exception.OperationException;
import com.atividade06.service.DepartamentoService;

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
}