package com.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.entity.Funcionario;
import com.prova.exception.OperationException;
import com.prova.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	public void save(Funcionario funcionario) throws OperationException {	
		try {			
		
			repository.save(funcionario);
		
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}	
}