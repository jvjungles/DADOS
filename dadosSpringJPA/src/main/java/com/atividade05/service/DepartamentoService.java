package com.atividade05.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.atividade05.entity.Departamento;
import com.atividade05.exception.OperationException;
import com.atividade05.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository repository;
    
    public void save(String name) {
    	
    	Departamento departamento = new Departamento();
		departamento.setNome_departamento(name);
		
    	repository.save(departamento);		
	}
    
    public void delete(Integer id) throws OperationException{
    	
    	try {
    		repository.delete(repository.findById(id.longValue()).get());
		} catch (NoSuchElementException e) {
			throw new OperationException("Departamento not found!");	
		} catch (DataIntegrityViolationException s) {
			throw new OperationException("There is an Funcionario in this Departamento!");
		}		 		
	}
    
    public Optional<Departamento> getById(Integer id) throws NoSuchElementException {
    	
    	try {
    		return repository.findById(id.longValue());
		} catch (NoSuchElementException e) {
			return null; 	
		}				
	}
    
    public List<Departamento> getAll() {
		return (List<Departamento>) repository.findAll();
	}

}
