package com.atividade05.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atividade05.entity.Departamento;
import com.atividade05.entity.Funcionario;
import com.atividade05.service.FuncionarioService;

@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@RequestMapping(value = "/funcionario/create")
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

	@RequestMapping(value = "/funcionario/delete")
	@ResponseBody
	public String delete() {
		
		Integer id = 1;
		Funcionario funcionario = new Funcionario();
		funcionario.setId(id.longValue());	
		
		funcionarioService.delete(funcionario);
		
		return "Funcionario succesfully deleted!";
	}
	
	@RequestMapping(value = "/funcionario/get-by-id")
	@ResponseBody
	public Funcionario getById() {
		
		Integer id = 1;
		
		Optional<Funcionario> funcionario =  funcionarioService.getById(id);
		
		return funcionario.get();
	}	
}
