package com.simulado;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.simulado.entity.Cantor;
import com.simulado.entity.Categoria;
import com.simulado.entity.Fone;
import com.simulado.entity.Gravacao;
import com.simulado.entity.Gravadora;
import com.simulado.entity.Musica;
import com.simulado.entity.Pessoa;
import com.simulado.service.CantorService;
import com.simulado.service.CategoriaService;
import com.simulado.service.FoneService;
import com.simulado.service.GravacaoService;
import com.simulado.service.GravadoraService;
import com.simulado.service.MusicaService;
import com.simulado.service.PessoaService;

@SpringBootApplication
public class ApplicationCommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationCommandLineRunner.class);

	public static void main(String[] args) {
		SpringApplication.run(ApplicationCommandLineRunner.class, args);
	}

	@Bean
	public CommandLineRunner demo(
					PessoaService pessoaService,
					FoneService foneService,
					CategoriaService categoriaService,
					MusicaService musicaService,
					GravadoraService gravadoraService,	
					CantorService cantorService,
					GravacaoService gravacaoService
			) {
		return (args) -> {
			
			// salvando alguns pessoa
			pessoaService.save(new Pessoa("nome_pessoa01"));
			pessoaService.save(new Pessoa("nome_pessoa02"));
			pessoaService.save(new Pessoa("nome_pessoa03"));
			
			// salvando alguns fone
			foneService.save(new Fone("numero01", "C", pessoaService.getFirst()));
			foneService.save(new Fone("numero02", "R", pessoaService.getFirst()));
			foneService.save(new Fone("numero03", "T", pessoaService.getFirst()));
			
			// salvando alguns categoria
			categoriaService.save(new Categoria("categoria01"));
			categoriaService.save(new Categoria("categoria02"));
			categoriaService.save(new Categoria("categoria03"));			
			
			// salvando alguns musica
			musicaService.save(new Musica("titulo01", 10, categoriaService.getFirst()));
			musicaService.save(new Musica("titulo02", 12, categoriaService.getFirst()));
			musicaService.save(new Musica("titulo03", 16, categoriaService.getFirst()));
			
			// salvando alguns gravadora
			gravadoraService.save(new Gravadora("nome_gravadora01", "USA"));
			gravadoraService.save(new Gravadora("nome_gravadora02", "BRASIL"));
			gravadoraService.save(new Gravadora("nome_gravadora03", "JAPAO"));
						
			// salvando alguns cantores
			cantorService.save(new Cantor("nome_cantor01", "USA"));
			cantorService.save(new Cantor("nome_cantor02", "BRASIL"));
			cantorService.save(new Cantor("nome_cantor03", "JAPAO"));
			
			// salvando alguns gravacoes
			gravacaoService.save(new Gravacao(new Date(), 
											  musicaService.findByTitulo("titulo01"), 
											  cantorService.findByName("nome_cantor01"), 
											  gravadoraService.findByName("nome_gravadora01")));			
			gravacaoService.save(new Gravacao(new Date(), 
											  musicaService.findByTitulo("titulo02"), 
											  cantorService.findByName("nome_cantor02"), 
											  gravadoraService.findByName("nome_gravadora02")));
			gravacaoService.save(new Gravacao(new Date(), 
											  musicaService.findByTitulo("titulo03"), 
											  cantorService.findByName("nome_cantor03"), 
											  gravadoraService.findByName("nome_gravadora03")));
			
			// retornando todos os endereços
			log.info("Gravacoes encontrados com findAll():");
			log.info("-------------------------------");
			for (Gravacao gravacoes : gravacaoService.getAll()) {
				log.info(gravacoes.toString());
			}
			log.info("");
			
			
		};
	}	
	
}
