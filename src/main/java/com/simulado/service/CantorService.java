package com.simulado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulado.entity.Cantor;
import com.simulado.exception.OperationException;
import com.simulado.repository.CantorRepository;

@Service
public class CantorService {

	@Autowired
	private CantorRepository repository;
	
	public void save(Cantor cantor) throws OperationException {	
		try {			
		
			repository.save(cantor);
		
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}	
	
	public void deleteAll() throws OperationException {	
		try {			
		
			repository.deleteAll();
		
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}
	
	public List<Cantor> getAll() throws OperationException{
		try {
			return (List<Cantor>) repository.findAll();
		} catch (Exception e) {
			throw new OperationException("Cantor not found!");
		}
	}	
	
	public List<Cantor> getByNomeCantor(String name) throws OperationException {
    	try {
    		return repository.findByNomeCantor(name);
		} catch (Exception e) {
			throw new OperationException("Cantor not found!");
		}
	}
	
	public Cantor getFirst() throws OperationException{
		try {
			return repository.findFirstBy();
		} catch (Exception e) {
			throw new OperationException("Cantor not found!");
		}
	}
	
	public Cantor getLast() throws OperationException{
		try {
			return repository.findFirstByOrderByIdDesc();
		} catch (Exception e) {
			throw new OperationException("Cantor not found!");
		}
	}
}