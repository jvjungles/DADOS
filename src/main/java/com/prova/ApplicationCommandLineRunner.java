package com.prova;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.prova.entity.Cargo;
import com.prova.entity.Funcionario;
import com.prova.service.CargoService;
import com.prova.service.FuncionarioService;

@SpringBootApplication
public class ApplicationCommandLineRunner {
	
	@Autowired
	CargoService cargoService;
	
	@Autowired
	FuncionarioService funcionarioService;
	

	public static void main(String[] args) {
		SpringApplication.run(ApplicationCommandLineRunner.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		
		return (args) -> {
			
			//SAVEs			
			saves();
			
			//SELECTs
			selectsCargo();
			selectsFuncionario();			
			
			//DELETEs			
			deletes(); 
			
		};
	}	
	
	// salvando dados
	private void saves() {
		
		System.out.println("");
		System.out.println("-----------------------------------------------------------------------");		
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("salvando dados");
		System.out.println("-----------------------------------------------------------------------");			
		System.out.println("-----------------------------------------------------------------------");
		
		try {
			
			System.out.println("");
			System.out.println("salvando alguns Cargos");
			cargoService.save(new Cargo("Cargo 01"));
			cargoService.save(new Cargo("Cargo 02"));
			cargoService.save(new Cargo("Cargo 03"));
			
			System.out.println("salvando alguns Funcionarios");
			funcionarioService.save(new Funcionario("Funcionario 01", "M", "41 9999-9999", cargoService.getFirst()));
			funcionarioService.save(new Funcionario("Funcionario 02", "F", "41 8888-8888", cargoService.getFirst()));
			funcionarioService.save(new Funcionario("Funcionario 03", "M", "41 7777-7777", cargoService.getLast()));
			
			System.out.println("\ndados salvo com sucesso");			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		
		System.out.println("");
		System.out.println("-----------------------------------------------------------------------");		
	}	

	
	
	//retornando dados - Cargo
	private void selectsCargo() {
		
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("retornando dados - Cargo");
		System.out.println("-----------------------------------------------------------------------");			
		System.out.println("-----------------------------------------------------------------------");	
		System.out.println("");
		
		try {
			
			System.out.println("Listar Cargos com a respectiva lista de Funcionarios");
			System.out.println("-------------------------------");
			
			for (Cargo cargos : cargoService.getAll()) {
				
				System.out.println(cargos.getCargo());
				
				if (cargos.getFuncionarios().size() != 0) {
					cargos.getFuncionarios().forEach(System.out::println);
				}else {
					System.out.println("Nenhum Funcionario cadastrado no " + cargos.getCargo());
				}
				
				System.out.println("");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 
		System.out.println("");
		System.out.println("");
		System.out.println("-----------------------------------------------------------------------");
	}
	
	
	//retornando dados - Funcionario
	private void selectsFuncionario() {
		
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("retornando dados - Funcionario");
		System.out.println("-----------------------------------------------------------------------");			
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("");	
		
		try {
			
			System.out.println("Listar Funcionários com os seus respectivos Cargos");
			System.out.println("-------------------------------");
			
			for (Funcionario funcionarios : funcionarioService.getAll()) {
				System.out.println(funcionarios.toString());
			}
				
			System.out.println("");		
			System.out.println("Listar o Nome de Funcionarios em Ordem Alfabetica");
			System.out.println("-------------------------------");			
			
			funcionarioService.getFuncionariosOrderByNome().stream().forEach(System.out::println);
				
			System.out.println("");		
			System.out.println("Listar a Quantidade de Funcionarios");
			System.out.println("-------------------------------");
			
			System.out.println("Quantidade de Funcionarios: " + funcionarioService.countFuncionarios());
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
				
		System.out.println("");		
		System.out.println("-----------------------------------------------------------------------");
	}	
	
	// deletando dados
	private void deletes() {
		
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("deletando dados");
		System.out.println("-----------------------------------------------------------------------");			
		System.out.println("-----------------------------------------------------------------------");
		
		try {
			
			System.out.println("\ndeletando funcionario: " + funcionarioService.getLast().getNome());
			
			funcionarioService.delete(funcionarioService.getLast().getId());
				
			System.out.println("funcionario deletado");
			
			System.out.println("\ndeletando cargo: " + cargoService.getLast().getCargo());
			
			cargoService.delete(cargoService.getLast().getId());
				
			System.out.println("cargo deletado");
			
			System.out.println("\ndeletando cargo exception: " + cargoService.getFirst().getCargo());
			System.out.println("");
			
			cargoService.delete(cargoService.getFirst().getId());
			
		} catch (Exception e) {
			System.out.println("");
			System.out.println("Message exception: " + e.getMessage());
		}
		
		System.out.println("\n-----------------------------------------------------------------------");
	}
}
