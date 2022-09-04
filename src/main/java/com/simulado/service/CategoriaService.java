package com.simulado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulado.entity.Categoria;
import com.simulado.exception.OperationException;
import com.simulado.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public void save(Categoria categoria) throws OperationException {	
		try {			
		
			repository.save(categoria);
		
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}
	
	public void delete(Categoria categoria) throws OperationException {	
		try {			
		
			repository.delete(categoria);
		
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}
	
	public Optional<Categoria> getById(Integer id) throws OperationException {
		try {
			return repository.findById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Categoria not found!");
		}
	}

	public List<Categoria> getAll() throws OperationException{
		try {
			return (List<Categoria>) repository.findAll();
		} catch (Exception e) {
			throw new OperationException("Categoria not found!");
		}
	}
	
	public boolean exists(Integer id) throws OperationException {		
		try {
			return repository.existsById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Categoria not found!");
		}
	}
	
	public Categoria findByDesc(String name) throws OperationException {
    	
    	if (name == null || name.equals("")) {
    		throw new OperationException("Categoria not found!");
		}
    	
    	try {  
    		
    		Categoria ret = repository.findCategoriaByDescCategoria(name);    	
    	
	    	if (ret == null) {
				throw new OperationException("Categoria not found!");
			}   	    	
		
			return ret;
		} catch (Exception e) {
			throw new OperationException(e.getMessage());
		}
	}
	
	public Categoria getFirst() throws OperationException{
		try {
			return repository.findFirstBy();
		} catch (Exception e) {
			throw new OperationException("Categoria not found!");
		}
	}
	
	public Categoria getLast() throws OperationException{
		try {
			return repository.findFirstByOrderByIdDesc();
		} catch (Exception e) {
			throw new OperationException("Categoria not found!");
		}
	}
}