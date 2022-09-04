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
			
			//SAVEs
			
			// salvando algumas pessoas
			pessoaService.save(new Pessoa("nome pessoa 01"));
			pessoaService.save(new Pessoa("nome pessoa 02"));
			pessoaService.save(new Pessoa("nome pessoa 03"));
			
			// salvando alguns fones
			foneService.save(new Fone("41 9999-9999", "C", pessoaService.getFirst()));
			foneService.save(new Fone("43 8888-8888", "R", pessoaService.getLast()));
			
			// salvando algumas categorias
			categoriaService.save(new Categoria("categoria 01"));
			categoriaService.save(new Categoria("categoria 02"));			
			
			// salvando algumas musicas
			musicaService.save(new Musica("titulo 01", 10, categoriaService.getFirst()));
			musicaService.save(new Musica("titulo 02", 12, categoriaService.getLast()));
			
			// salvando alguns cantores
			cantorService.save(new Cantor("nome cantor 01", "USA"));
			cantorService.save(new Cantor("nome cantor 02", "BRASIL"));
			cantorService.save(new Cantor("nome cantor 03", "JAPAO"));
			
			// salvando algumas gravadoras
			gravadoraService.save(new Gravadora("nome gravadora 01", "USA"));
			gravadoraService.save(new Gravadora("nome gravadora 02", "BRASIL"));
			gravadoraService.save(new Gravadora("nome gravadora 03", "JAPAO"));
			
			// salvando algumas gravacoes
			gravacaoService.save(new Gravacao(new Date(), 
											  musicaService.getFirst(), 
											  cantorService.getFirst(), 
											  gravadoraService.getFirst()));			
			gravacaoService.save(new Gravacao(new Date(), 
											  musicaService.getLast(), 
											  cantorService.getLast(), 
											  gravadoraService.getLast()));
			
			// SELECTs
			log.info("-----------------------------------------------------------------------");
			
			//retornando dados - Pessoa
			log.info("-----------------------------------------------------------------------");
			log.info("retornando dados - Pessoa");
			log.info("-----------------------------------------------------------------------");
			
			log.info("-----------------------------------------------------------------------");
			
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
			
			
			//retornando dados - Fone
			log.info("-----------------------------------------------------------------------");
			log.info("retornando dados - Fone");
			log.info("-----------------------------------------------------------------------");
			
			log.info("-----------------------------------------------------------------------");
			
			log.info("Fones encontrados com findAll():");
			log.info("-------------------------------");
			for (Fone fones : foneService.getAll()) {
				log.info(fones.toString());
			}
			log.info("");
			
			log.info("Fone encontrado com getByNumero():");
			log.info("-------------------------------");			
			
			log.info(foneService.getByNumero("41 9999-9999").toString());
						
			log.info("");
			
			log.info("-----------------------------------------------------------------------");
			
			
			
			
			
						
//			// retornando todos sa gravacoes
//			log.info("Gravacoes encontrados com findAll():");
//			log.info("-------------------------------");
//			for (Gravacao gravacoes : gravacaoService.getAll()) {
//				log.info(gravacoes.toString());
//			}
//			log.info("");
//			
//			// retornando musicas like nome
//			log.info("Musicas encontrados com like nome:");
//			log.info("-------------------------------");
//			for (Musica musicas : musicaService.findByNomeLike("titulo")) {
//				log.info(musicas.toString());
//			}
//			log.info("");		
			
		};
	}
}
