package com.atividade06.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.atividade06.entity.Funcionario;
import com.atividade06.exception.OperationException;
import com.atividade06.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	 @Autowired
    private FuncionarioRepository repository;
    
    public void save(Funcionario funcionario) throws OperationException {    	
    	try {
    		
    		if (repository.findFuncionarioByCpf(funcionario.getCpf()) != null) {
    			throw new OperationException("Funcionario exists!");
			}   		
    		
    		repository.save(funcionario);
    		
		} catch (DataIntegrityViolationException e) {
			
			if (e.getMessage().contains("cpf")) {
				throw new OperationException("Funcionario - CPF nao informado!");
			}else {
				throw new OperationException("Departamento not found!");
			}
			
		} catch (Exception e) {
			throw new OperationException("Funcionario - CPF exists!");
		}
	}
    
    public void delete(Integer id) throws OperationException {    	
    	try {
			repository.delete(
					repository.findById(id.longValue()).get()
			);
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
    
    public Funcionario findByCpf(String cpf) throws OperationException {    	   	    	
		try {
			return repository.findFuncionarioByCpf(cpf);
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
		
    	Funcionario funcionario = new Funcionario(name);    	
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