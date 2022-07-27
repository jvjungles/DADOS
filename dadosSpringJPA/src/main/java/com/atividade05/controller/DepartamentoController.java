package com.atividade05.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atividade05.entity.Departamento;
import com.atividade05.service.DepartamentoService;

@RestController
@RequestMapping(path = "/departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;
	
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(String name) {
		
		Departamento departamento = new Departamento();
		departamento.setNome_departamento("Fera");

		departamentoService.save(departamento);
		
		return "Departamento succesfully created!!! \n\n " + departamento.toString();
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete() {		
		
		Integer id = 1;
		Departamento departamento = new Departamento();
		departamento.setId(id.longValue());

		departamentoService.delete(departamento);		
		
		return "Departamento succesfully deleted!";
	}
	
	@RequestMapping(value = "/get-by-id")
	@ResponseBody
	public String getById() {
		
		Optional<Departamento> departamento = departamentoService.getById(1);
		
		return "The departamento is: " + departamento.get().getNome_departamento();
	}

	@RequestMapping(value = "/departamento/get-all")
	@ResponseBody
	public List<Departamento> getByAll() {
		
		return departamentoService.getAll();		
	}	
}
