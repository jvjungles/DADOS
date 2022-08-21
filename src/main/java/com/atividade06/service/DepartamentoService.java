package com.atividade06.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.atividade06.entity.Departamento;
import com.atividade06.exception.OperationException;
import com.atividade06.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository repository;

	public void save(Departamento departamento) throws OperationException {		
		try {
			repository.save(departamento);
		} catch (Exception e) {
			throw new OperationException("Departamento not save!");
		}
	}

	public void delete(Integer id) throws OperationException {
		try {
			repository.delete(
					repository.findById(id.longValue()).get()
			);
		} catch (NoSuchElementException e) {
			throw new OperationException("Departamento not found!");
		} catch (DataIntegrityViolationException s) {
			throw new OperationException("There is an Funcionario in this Departamento!");
		} catch (NullPointerException e) {
			throw new OperationException("Departamento not found!");
		}
	}

	public Optional<Departamento> getById(Integer id) throws OperationException {
		try {
			return repository.findById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Departamento not found!");
		}
	}

	public List<Departamento> getAll() throws OperationException{
		try {
			return (List<Departamento>) repository.findAll();
		} catch (Exception e) {
			throw new OperationException("Departamento not found!");
		}
	}
	
	public boolean exists(Integer id) throws OperationException {		
		try {
			return repository.existsById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Departamento not found!");
		}
	}
	
	public Departamento findFirstBy() throws OperationException {	    	
		try {
			
			Departamento depertamento = repository.findFirstBy();
			
			if (depertamento.getId() == null) {
				throw new OperationException("Departamento not found!");
			}
			
			return depertamento;
		} catch (Exception e) {
			throw new OperationException("Departamento not found!");
		}
	}
}