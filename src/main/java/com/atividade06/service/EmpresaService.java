package com.atividade06.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.atividade06.entity.Empresa;
import com.atividade06.exception.OperationException;
import com.atividade06.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
    private EmpresaRepository repository;
    
    public void save(Empresa empresa) throws OperationException {   
    	
    	try {			
		
	    	isvalid(empresa);    	
	    	repository.save(empresa);	
	    	
    	} catch (Exception e) {
			throw new OperationException(e.getMessage());
		}
	}

	private void isvalid(Empresa empresa) throws OperationException {
		if (empresa == null ||empresa.getNome_empresa() == null) {
    		throw new OperationException("Empresa not infomed!");
		}
	}
    
    public void delete(Integer id) throws OperationException {
    	try {
			repository.delete(
					repository.findById(id.longValue()).get()
			);
		} catch (NoSuchElementException e) {
			throw new OperationException("Empresa not found!");
		} catch (DataIntegrityViolationException s) {
			throw new OperationException("There is an Departamento in this Empresa!");
		} catch (NullPointerException e) {
			throw new OperationException("Empresa not found!");
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
			throw new OperationException("Empresa not found!");
		}
	}
    
    public boolean exists(Integer id) throws OperationException {
		try {
			return repository.existsById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Empresa not found!");
		}
	}
}