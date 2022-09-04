package com.simulado;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.simulado.exception.OperationException;
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
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	FoneService foneService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	MusicaService musicaService;
	
	@Autowired
	GravadoraService gravadoraService;	
	
	@Autowired
	CantorService cantorService;
	
	@Autowired
	GravacaoService gravacaoService;
	

	public static void main(String[] args) {
		SpringApplication.run(ApplicationCommandLineRunner.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		
		return (args) -> {
			
			//SAVEs			
			saves();
			
			// SELECTs
			selectsPessoa();
			selectsFone();
			selectsCategoria();
			selectsMusica();
			selectsCantor();
			selectsGravadora();
			selectsGravacao();
			
			//DELETEs			
			deletes();
			
			
		
			
		};
	}	
	
	private void saves() throws OperationException {
		
		log.info("");
		log.info("-----------------------------------------------------------------------");		
		log.info("-----------------------------------------------------------------------");
		log.info("salvando dados");
		log.info("-----------------------------------------------------------------------");			
		log.info("-----------------------------------------------------------------------");
		
		// salvando algumas pessoas
		pessoaService.save(new Pessoa("nome pessoa 01"));
		pessoaService.save(new Pessoa("nome pessoa 02"));
		pessoaService.save(new Pessoa("nome pessoa 03"));
		log.info("pessoas inseridas");
		
		// salvando alguns fones
		foneService.save(new Fone("41 9999-9999", "C", pessoaService.getFirst()));
		foneService.save(new Fone("43 8888-8888", "R", pessoaService.getLast()));
		log.info("fones inseridos");
		
		// salvando algumas categorias
		categoriaService.save(new Categoria("categoria 01"));
		categoriaService.save(new Categoria("categoria 02"));			
		log.info("categorias inseridas");
		
		// salvando algumas musicas
		musicaService.save(new Musica("titulo 01", 10, categoriaService.getFirst()));
		musicaService.save(new Musica("titulo 02", 12, categoriaService.getLast()));
		log.info("musicas inseridas");
		
		// salvando alguns cantores
		cantorService.save(new Cantor("nome cantor 01", "USA"));
		cantorService.save(new Cantor("nome cantor 02", "BRASIL"));
		cantorService.save(new Cantor("nome cantor 03", "JAPAO"));
		log.info("cantores inseridos");
		
		// salvando algumas gravadoras
		gravadoraService.save(new Gravadora("nome gravadora 01", "USA"));
		gravadoraService.save(new Gravadora("nome gravadora 02", "BRASIL"));
		gravadoraService.save(new Gravadora("nome gravadora 03", "JAPAO"));
		log.info("gravadoras inseridas");
		
		// salvando algumas gravacoes
		gravacaoService.save(new Gravacao(new Date(), 
										  musicaService.getFirst(), 
										  cantorService.getFirst(), 
										  gravadoraService.getFirst()));			
		gravacaoService.save(new Gravacao(new Date(), 
										  musicaService.getLast(), 
										  cantorService.getLast(), 
										  gravadoraService.getLast()));
		log.info("gravacoes inseridas");
		log.info("");
		log.info("-----------------------------------------------------------------------");
		
	}	

	//retornando dados - Pessoa
	private void selectsPessoa() throws OperationException {
		
		log.info("-----------------------------------------------------------------------");
		log.info("retornando dados - Pessoa");
		log.info("-----------------------------------------------------------------------");			
		log.info("-----------------------------------------------------------------------");
		log.info("");
		log.info("Pessoas encontradas com findAll():");
		log.info("-------------------------------");
			for (Pessoa pessoa : pessoaService.getAll()) {
				log.info(pessoa.toString());
			}
		log.info("");			
		log.info("Pessoa encontrada com getAllByQuery():");
		log.info("-------------------------------");			
			for (Pessoa pessoa : pessoaService.getAllByQuery()) { 
				log.info(pessoa.toString());
			}			
		log.info("");			
		log.info("-----------------------------------------------------------------------");
	}
	
	//retornando dados - Fone
	private void selectsFone() throws OperationException { 
		
		log.info("-----------------------------------------------------------------------");
		log.info("retornando dados - Fone");
		log.info("-----------------------------------------------------------------------");			
		log.info("-----------------------------------------------------------------------");
		log.info("");
		log.info("Fones encontrados com findAll():");
		log.info("-------------------------------");
			for (Fone fones : foneService.getAll()) {
				log.info(fones.toString());
			}
		log.info("");			
		log.info("Fones encontrados com getByNumero()");
		log.info("-------------------------------");		
			for (Fone fones : foneService.getByNumero(foneService.getFirst().getNumero())) {
				log.info(fones.toString());
			}
		log.info("");			
		log.info("-----------------------------------------------------------------------");
	}
	
	//retornando dados - Categoria
	private void selectsCategoria() throws OperationException {
		
		log.info("-----------------------------------------------------------------------");
		log.info("retornando dados - Categoria");
		log.info("-----------------------------------------------------------------------");			
		log.info("-----------------------------------------------------------------------");
		log.info("");
		log.info("Categorias encontradas com findAll():");
		log.info("-------------------------------");
			for (Categoria categorias : categoriaService.getAll()) {
				log.info(categorias.toString());
			}
		log.info("");	
		log.info("Categorias encontradas com getByDescCategoria()");
		log.info("-------------------------------");		
			for (Categoria categorias : categoriaService.getByDescCategoria(categoriaService.getFirst().getDescCategoria())) {
				log.info(categorias.toString());
			}
		log.info("");
		log.info("-----------------------------------------------------------------------");
	}
	
	
	//retornando dados - Musica
	private void selectsMusica() throws OperationException {
		
		log.info("-----------------------------------------------------------------------");
		log.info("retornando dados - Musica");
		log.info("-----------------------------------------------------------------------");			
		log.info("-----------------------------------------------------------------------");
		
		log.info("");
		log.info("Musicas encontradas com findAll():");
		log.info("-------------------------------");
			for (Musica musicas : musicaService.getAll()) {
				log.info(musicas.toString());
			}
		log.info("");
		log.info("Musicas encontradas com like titulo:");
		log.info("-------------------------------");
			for (Musica musicas : musicaService.getByTituloLike(musicaService.getFirst().getTitulo())) {
				log.info(musicas.toString());
			}
		log.info("");
		log.info("-----------------------------------------------------------------------");
	}
	
	//retornando dados - Cantor
	private void selectsCantor() throws OperationException {
		
		log.info("-----------------------------------------------------------------------");
		log.info("retornando dados - Cantor");
		log.info("-----------------------------------------------------------------------");			
		log.info("-----------------------------------------------------------------------");
		
		log.info("");
		log.info("Cantores encontrados com findAll():");
		log.info("-------------------------------");
			for (Cantor cantores : cantorService.getAll()) {
				log.info(cantores.toString());
			}
		log.info("");
		log.info("Cantor encontrado com nome cantor:");
		log.info("-------------------------------");		
			for (Cantor cantores : cantorService.getByNomeCantor(cantorService.getFirst().getNomeCantor())) {
				log.info(cantores.toString());
			}	
		log.info("");
		log.info("-----------------------------------------------------------------------"); 
	}
	
	//retornando dados - Gravadora
	private void selectsGravadora() throws OperationException {
		
		log.info("-----------------------------------------------------------------------");
		log.info("retornando dados - Gravadora");
		log.info("-----------------------------------------------------------------------");			
		log.info("-----------------------------------------------------------------------");
		
		log.info("");
		log.info("Gravadoras encontradas com findAll():");
		log.info("-------------------------------");
			for (Gravadora gravadora : gravadoraService.getAll()) {
				log.info(gravadora.toString());
			}
		log.info("");
		log.info("Gravadora encontrada com nome gravadora:");
		log.info("-------------------------------");		
			for (Gravadora gravadora : gravadoraService.getByNomeGravadora(gravadoraService.getFirst().getNomeGravadora())) {
				log.info(gravadora.toString());
			}
		log.info("");
		log.info("-----------------------------------------------------------------------");
	}
	
	//retornando dados - Gravacao
	private void selectsGravacao() throws OperationException {
		
		log.info("-----------------------------------------------------------------------");
		log.info("retornando dados - Gravacao");
		log.info("-----------------------------------------------------------------------");			
		log.info("-----------------------------------------------------------------------");
		
		log.info("");
		log.info("Gravacoes encontradas com findAll():");
		log.info("-------------------------------");
			for (Gravacao gravacoes : gravacaoService.getAll()) {
				log.info(gravacoes.toString());
			}
		log.info("");		
		log.info("");
		log.info("Gravacoes encontradas com findGravacaoByCantorNq():");
		log.info("-------------------------------");
			for (Gravacao gravacoes : gravacaoService.getGravacaoByCantorNq(cantorService.getFirst().getId())) {
				log.info(gravacoes.toString());
			}
		log.info("");		
		log.info("");
		log.info("Gravacoes encontradas com findGravacaoByGravadora():");
		log.info("-------------------------------");
			for (Gravacao gravacoes : gravacaoService.getGravacaoByGravadora(gravadoraService.getLast().getId())) {
				log.info(gravacoes.toString());
			}
		log.info("");
		log.info("-----------------------------------------------------------------------");
	}
	
	private void deletes() throws OperationException {
		
		log.info("");
		log.info("-----------------------------------------------------------------------");		
		log.info("-----------------------------------------------------------------------");
		log.info("deletando dados");
		log.info("-----------------------------------------------------------------------");			
		log.info("-----------------------------------------------------------------------");
		
		foneService.deleteAll();
		log.info("fones deletados");
		gravacaoService.deleteAll();
		log.info("gravacoes deletadas");
		pessoaService.deleteAll();		
		log.info("pessoas deletadas");
		musicaService.deleteAll();
		log.info("musicas deletadas");
		gravadoraService.deleteAll();	
		log.info("gravadoras deletadas");
		cantorService.deleteAll();	
		log.info("cantores deletados");
		categoriaService.deleteAll();
		log.info("categorias deletadas");
		
		log.info("-----------------------------------------------------------------------");
	}
}
