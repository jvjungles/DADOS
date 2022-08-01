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

import com.atividade05.entity.Empresa;
import com.atividade05.exception.OperationException;
import com.atividade05.service.EmpresaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	@ApiOperation(value = "Create Empresa", notes = "Method responsible for create Empresa")
	@PostMapping(value = "/create")
	public String create(String name) {
		
		Empresa empresa = new Empresa();		
		empresa.setNome_empresa(name);
		
		try {
			empresaService.save(empresa);
		} catch (OperationException e) {
			return e.getMessage();
		}
		return "Empresa succesfully created!!! \n\n";
	}

	@ApiOperation(value = "Delete Empresa by ID", notes = "Method responsible for delete Empresa")
	@DeleteMapping(value = "/delete")
	@ResponseBody
	public String delete(Integer id) {
		
		try {
			empresaService.delete(id);
		} catch (OperationException e) {
			return e.getMessage();
		}
		return "Empresa succesfully deleted!";
	}
	
	@ApiOperation(value = "Find Empresa by ID", notes = "Method responsible for searching Empresa by ID")
	@PostMapping(value = "/get-by-id")
	@ResponseBody
	public String getById(Integer id) {
		
		Optional<Empresa> empresa;
		try {
			empresa =  empresaService.getById(id);
			return "Empresa is: " + empresa.get().getNome_empresa();
		} catch (Exception e) {
			return "Empresa not found!";
		}
	}	
	
	@ApiOperation(value = "Find All Empresas", notes = "Method responsible for searching all Empresas.")
	@GetMapping(value = "/get-all")
	@ResponseBody
	public List<Empresa> getByAll() {

		try {
			return empresaService.getAll();
		} catch (Exception e) {
			return null;
		}
	}
}
