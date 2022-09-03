package com.simulado.service;

import java.util.List;
import java.util.Optional;

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
	
	public void delete(Fone fone) throws OperationException {	
		try {			
		
			repository.delete(fone);
		
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}
	
	public Optional<Fone> getById(Integer id) throws OperationException {
		try {
			return repository.findById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Fone not found!");
		}
	}

	public List<Fone> getAll() throws OperationException{
		try {
			return (List<Fone>) repository.findAll();
		} catch (Exception e) {
			throw new OperationException("Fone not found!");
		}
	}
	
	public boolean exists(Integer id) throws OperationException {		
		try {
			return repository.existsById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Fone not found!");
		}
	}	
}