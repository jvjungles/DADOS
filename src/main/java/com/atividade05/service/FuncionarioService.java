package com.atividade05.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.atividade05.entity.Funcionario;
import com.atividade05.exception.OperationException;
import com.atividade05.repository.FuncionarioRepository;


@Service
public class FuncionarioService {

	 @Autowired
    private FuncionarioRepository repository;
    
    public void save(Funcionario funcionario) throws OperationException {
    	
    	try {
    		repository.save(funcionario);
		} catch (Exception e) {
			throw new OperationException("Funcionario not save!");
		}
	}
    
    public void delete(Integer id) throws OperationException {
    	
    	try {
			repository.delete(repository.findById(id.longValue()).get());
		} catch (NoSuchElementException e) {
			throw new OperationException("Funcionario not found!");
		} catch (NullPointerException e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public Optional<Funcionario> getById(Integer id) throws OperationException {
    	
    	try {
    		return repository.findById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> getAll() throws OperationException {		
		
		try {
			return (List<Funcionario>) repository.findAll();
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public boolean exists(Integer id) throws OperationException {	
		
		try {
			return repository.existsById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> findByName(String name) throws OperationException {
    	
    	if (name.equals("")) {
    		throw new OperationException("Funcionario not found!");
		}
		
    	Funcionario funcionario = new Funcionario();
    	funcionario.setNome_funcionario(name);
    	
    	Example<Funcionario> example = Example.of(funcionario);
    	    	
		try {
			return repository.findAll(example);
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> findBySalario(Double salario) throws OperationException {		
    	   	    	
		try {
			return repository.findFuncionarioBySalario(salario);
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> findAllByQuery() throws OperationException {		
	    	
		try {
			return repository.findAllByQuery();
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
}
