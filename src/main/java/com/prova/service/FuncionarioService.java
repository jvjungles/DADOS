package com.prova.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.entity.Funcionario;
import com.prova.exception.OperationException;
import com.prova.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	public void save(Funcionario funcionario) throws OperationException {	
		try {
			repository.save(funcionario);
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}	
	
	public void delete(Long id) throws OperationException {    	
    	try {
			repository.delete(
					repository.findById(id).get());
		} catch (NoSuchElementException e) {
			throw new OperationException("Funcionario not found!");
		}
	}
	
	public List<Funcionario> getAll() throws OperationException{
		try {
			return (List<Funcionario>) repository.findAll();
		} catch (Exception e) {
			throw new OperationException("Funcionarios not found!");
		}
	}
	
	public List<String> getFuncionariosOrderByNome() throws OperationException{
		try {
			return repository.findFuncionariosOrderByNome();
		} catch (Exception e) {
			throw new OperationException("Funcionarios not found!");
		}
	}
	
	public Integer countFuncionarios() throws OperationException{
		try {
			return repository.countFuncionarios();
		} catch (Exception e) {
			throw new OperationException("Funcionarios not found!");
		}
	}
	
	public Funcionario getFirst() throws OperationException{
		try {
			return repository.findFirstBy();
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
	
	public Funcionario getLast() throws OperationException{
		try {
			return repository.findFirstByOrderByIdDesc();
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
}