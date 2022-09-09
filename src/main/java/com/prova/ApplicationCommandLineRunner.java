package com.prova;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			selectsFuncionarios();			
			
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
		
		// salvando alguns Funcionarios
		
		
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
		log.info("-----------------------------------------------------------------------");
	}
	
	
	//retornando dados - Musica
	private void selectsFuncionarios() throws OperationException {
		
		log.info("-----------------------------------------------------------------------");
		log.info("retornando dados - Funcionarios");
		log.info("-----------------------------------------------------------------------");			
		log.info("-----------------------------------------------------------------------");
		
		
		
		
		log.info("");
		log.info("-----------------------------------------------------------------------");
	}	
	
	// deletando dados
	private void deletes() throws OperationException {
		
		log.info("-----------------------------------------------------------------------");
		log.info("deletando dados");
		log.info("-----------------------------------------------------------------------");			
		log.info("-----------------------------------------------------------------------");
		
		log.info("funcionarios deletados");
		
		log.info("cargos deletados");
		
		log.info("-----------------------------------------------------------------------");
	}
}
