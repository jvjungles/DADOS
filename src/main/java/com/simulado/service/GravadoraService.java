package com.simulado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulado.entity.Gravadora;
import com.simulado.exception.OperationException;
import com.simulado.repository.GravadoraRepository;

@Service
public class GravadoraService {

	@Autowired
	private GravadoraRepository repository;
	
	public void save(Gravadora gravadora) throws OperationException {	
		try {			
		
			repository.save(gravadora);
		
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
	
	public Optional<Gravadora> getById(Integer id) throws OperationException {
		try {
			return repository.findById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Gravadora not found!");
		}
	}

	public List<Gravadora> getAll() throws OperationException{
		try {
			return (List<Gravadora>) repository.findAll();
		} catch (Exception e) {
			throw new OperationException("Gravadora not found!");
		}
	}
	
	public List<Gravadora> getByNomeGravadora(String name) throws OperationException {    	
    	try {
    		return repository.findByNomeGravadora(name);
		} catch (Exception e) {
			throw new OperationException(e.getMessage());
		}
	}
	
	public Gravadora getFirst() throws OperationException{
		try {
			return repository.findFirstBy();
		} catch (Exception e) {
			throw new OperationException("Gravadora not found!");
		}
	}
	
	public Gravadora getLast() throws OperationException{
		try {
			return repository.findFirstByOrderByIdDesc();
		} catch (Exception e) {
			throw new OperationException("Gravadora not found!");
		}
	}
}