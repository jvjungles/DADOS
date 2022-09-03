package com.simulado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulado.repository.CantorRepository;

@Service
public class PessoaService {

	@Autowired
	private CantorRepository repository;
	
	
}