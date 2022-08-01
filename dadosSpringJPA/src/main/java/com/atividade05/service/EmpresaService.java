package com.atividade05.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.atividade05.entity.Empresa;
import com.atividade05.exception.OperationException;
import com.atividade05.repository.EmpresaRepository;

@Service
public class EmpresaService {

	 @Autowired
    private EmpresaRepository repository;
    
    public void save(Empresa empresa) throws OperationException {
    	    	
    	try {
    		repository.save(empresa);
		} catch (Exception e) {
			throw new OperationException("Empresa not save!");
		}
	}
    
    public void delete(Integer id) throws OperationException {    	
    	
    	try {
			repository.delete(repository.findById(id.longValue()).get());
		} catch (NoSuchElementException e) {
			throw new OperationException("Empresa not found!");
		} catch (DataIntegrityViolationException s) {
			throw new OperationException("There is an Departamento in this Empresa!");
		}
	}
    
    public Optional<Empresa> getById(Integer id) throws OperationException {
    		
    	
    	try {
    		return repository.findById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Empresa not found!");
		}
	}
    
    public List<Empresa> getAll() throws OperationException {	
		
		try {
			return (List<Empresa>) repository.findAll();
		} catch (Exception e) {
			
		}
		return null;
	}
    
    public boolean exists(Integer id) throws OperationException {	
		
		try {
			return repository.existsById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Empresa not found!");
		}
	}
}
