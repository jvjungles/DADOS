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
import com.atividade05.service.FuncionarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@ApiOperation(value = "Create Funcionario", notes = "Method responsible for create Funcionario")
	@PostMapping(value = "/create")
	public String create() {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCargo("Cargo");
		funcionario.setNome_funcionario("Nome_funcionario");
		funcionario.setQtde_dependente(10);
		funcionario.setSalario((double) 1000);
		
		Departamento departamento = new Departamento();
		departamento.setId((long) 1);
		funcionario.setDepartamento(departamento);

		funcionarioService.save(funcionario);		
		
		return "Funcionario succesfully created!!! \n\n " + funcionario.toString();
	}

	@ApiOperation(value = "Delete Funcionario by ID", notes = "Method responsible for delete Funcionario")
	@DeleteMapping(value = "/delete")
	@ResponseBody
	public String delete(Integer id) {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId(id.longValue());	
		
		funcionarioService.delete(funcionario);
		
		return "Funcionario succesfully deleted!";
	}
	
	@ApiOperation(value = "Find Funcionario by ID", notes = "Method responsible for searching Funcionario by ID")
	@PostMapping(value = "/get-by-id")
	@ResponseBody
	public Funcionario getById(Integer id) {
		
		Optional<Funcionario> funcionario =  funcionarioService.getById(id);
		
		return funcionario.get();
	}	
	
	@ApiOperation(value = "Find All Funcionarios", notes = "Method responsible for searching all Funcionarios.")
	@GetMapping(value = "/get-all")
	@ResponseBody
	public List<Funcionario> getByAll() {

		return funcionarioService.getAll();
	}
}
