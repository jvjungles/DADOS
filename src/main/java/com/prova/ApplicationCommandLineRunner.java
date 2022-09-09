package com.prova;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.prova.entity.Cargo;
import com.prova.entity.Funcionario;
import com.prova.exception.OperationException;
import com.prova.service.CargoService;
import com.prova.service.FuncionarioService;

@SpringBootApplication
public class ApplicationCommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationCommandLineRunner.class);
	
	@Autowired
	CargoService cargoService;
	
	@Autowired
	FuncionarioService funcionarioService;
	

	public static void main(String[] args) {
		SpringApplication.run(ApplicationCommandLineRunner.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		
		return (args) -> {
			
			//SAVEs			
			saves();
			
			// SELECTs
			selectsCargo();
			selectsFuncionario();			
			
			//DELETEs			
			deletes(); 
			
		};
	}	
	
	// salvando dados
	private void saves() throws OperationException {
		
		log.info("");
		log.info("-----------------------------------------------------------------------");		
		log.info("-----------------------------------------------------------------------");
		log.info("salvando dados");
		log.info("-----------------------------------------------------------------------");			
		log.info("-----------------------------------------------------------------------");
		
		// salvando alguns Cargos
		cargoService.save(new Cargo("Cargo 01"));
		cargoService.save(new Cargo("Cargo 02"));
		cargoService.save(new Cargo("Cargo 03"));
		
		// salvando alguns Funcionarios
		funcionarioService.save(new Funcionario("Funcionario 01", "M", "41 9999-9999", cargoService.getFirst()));
		funcionarioService.save(new Funcionario("Funcionario 02", "F", "41 8888-8888", cargoService.getFirst()));
		funcionarioService.save(new Funcionario("Funcionario 03", "M", "41 7777-7777", cargoService.getLast()));
		
		
		log.info("dados salvo com sucesso");
		log.info("");
		log.info("-----------------------------------------------------------------------");
		
	}	

	
	
	//retornando dados - Categoria
	private void selectsCargo() throws OperationException {
		
		log.info("-----------------------------------------------------------------------");
		log.info("retornando dados - Cargo");
		log.info("-----------------------------------------------------------------------");			
		log.info("-----------------------------------------------------------------------");				
		log.info("");
		log.info("Listar Cargos com a respectiva lista de Funcionarios");
		log.info("-------------------------------");
			for (Cargo cargos : cargoService.getAll()) {
				log.info(cargos.toString());
			}
		log.info("");
		log.info("");
		log.info("-----------------------------------------------------------------------");
	}
	
	
	//retornando dados - Musica
	private void selectsFuncionario() throws OperationException {
		
		log.info("-----------------------------------------------------------------------");
		log.info("retornando dados - Funcionario");
		log.info("-----------------------------------------------------------------------");			
		log.info("-----------------------------------------------------------------------");
		log.info("");		
		log.info("Listar Funcionários com os seus respectivos Cargos");
		log.info("-------------------------------");
			for (Funcionario funcionarios : funcionarioService.getAll()) {
				log.info(funcionarios.toString());
			}
		log.info("");		
		log.info("Listar o Nome de Funcionarios em Ordem Alfabetica");
		log.info("-------------------------------");			
			funcionarioService.getFuncionariosOrderByNome().stream().forEach(System.out::println);		
		log.info("");		
		log.info("Listar a Quantidade de Funcionarios");
		log.info("-------------------------------");			
			System.out.println("Quantidade de Funcionarios: " + funcionarioService.countFuncionarios());		
		log.info("");		
		log.info("-----------------------------------------------------------------------");
	}	
	
	// deletando dados
	private void deletes() throws OperationException {
		
		log.info("-----------------------------------------------------------------------");
		log.info("deletando dados");
		log.info("-----------------------------------------------------------------------");			
		log.info("-----------------------------------------------------------------------");
		
		funcionarioService.delete(funcionarioService.getLast().getId());		
		log.info("funcionario deletado");
		
		cargoService.delete(cargoService.getLast().getId());
		log.info("cargos deletados");
		
		log.info("-----------------------------------------------------------------------");
	}
}
