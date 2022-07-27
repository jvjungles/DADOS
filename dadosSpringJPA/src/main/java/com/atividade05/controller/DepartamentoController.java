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
import com.atividade05.service.DepartamentoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;

	@ApiOperation(value = "Create Departamento", notes = "Method responsible for create Departamento")
	@PostMapping(value = "/create")
	@ResponseBody
	public String create(String name) {

		Departamento departamento = new Departamento();
		departamento.setNome_departamento(name);

		departamentoService.save(departamento);

		return "Departamento succesfully created!!! \n\n " + departamento.toString();
	}

	@ApiOperation(value = "Delete Departamento by ID", notes = "Method responsible for delete Departamento by ID")
	@DeleteMapping(value = "/delete")
	@ResponseBody
	public String delete(Integer id) {

		Departamento departamento = new Departamento();
		departamento.setId(id.longValue());

		departamentoService.delete(departamento);

		return "Departamento succesfully deleted!";
	}

	@ApiOperation(value = "Find Departamento by ID", notes = "Method responsible for searching Departamento by ID")
	@PostMapping(value = "/get-by-id")
	@ResponseBody
	public String getById(Integer id) {

		Optional<Departamento> departamento = departamentoService.getById(id);

		return "The departamento is: " + departamento.get().getNome_departamento();
	}

	@ApiOperation(value = "Find All Departamentos", notes = "Method responsible for searching all Departamento.")
	@GetMapping(value = "/get-all")
	@ResponseBody
	public List<Departamento> getByAll() {

		return departamentoService.getAll();
	}
}
