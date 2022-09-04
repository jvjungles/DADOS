package com.simulado.service;

import java.util.List;
import java.util.Optional;

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
	
	public void delete(Cantor cantor) throws OperationException {	
		try {			
		
			repository.delete(cantor);
		
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}
	
	public Optional<Cantor> getById(Integer id) throws OperationException {
		try {
			return repository.findById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Cantor not found!");
		}
	}

	public List<Cantor> getAll() throws OperationException{
		try {
			return (List<Cantor>) repository.findAll();
		} catch (Exception e) {
			throw new OperationException("Cantor not found!");
		}
	}
	
	public boolean exists(Integer id) throws OperationException {		
		try {
			return repository.existsById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Cantor not found!");
		}
	}
	
	public Cantor findByName(String name) throws OperationException {
    	
    	if (name == null || name.equals("")) {
    		throw new OperationException("Cantor not found!");
		}
    	
    	try {  
    		
    		Cantor ret = repository.findByNomeCantor(name);
    	
	    	if (ret == null) {
				throw new OperationException("Cantor not found!");
			}   	    	
		
			return ret;
		} catch (Exception e) {
			throw new OperationException(e.getMessage());
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