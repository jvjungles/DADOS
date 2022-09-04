package com.simulado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulado.entity.Fone;
import com.simulado.exception.OperationException;
import com.simulado.repository.FoneRepository;

@Service
public class FoneService {

	@Autowired
	private FoneRepository repository;
	
	public void save(Fone fone) throws OperationException {	
		try {			
		
			repository.save(fone);
		
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
	
	public List<Fone> getAll() throws OperationException{
		try {
			return (List<Fone>) repository.findAll();
		} catch (Exception e) {
			throw new OperationException("Fone not found!");
		}
	}
	
	public Fone getFirst() throws OperationException{
		try {
			return repository.findFirstBy();
		} catch (Exception e) {
			throw new OperationException("Fone not found!");
		}
	}
	
	public List<Fone> getByNumero(String numero) throws OperationException {
    	try {
    		return repository.findByNumero(numero);
		} catch (Exception e) {
			throw new OperationException(e.getMessage());
		}
	}
}