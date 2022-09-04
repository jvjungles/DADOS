package com.simulado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulado.entity.Pessoa;
import com.simulado.exception.OperationException;
import com.simulado.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public void save(Pessoa pessoa) throws OperationException {	
		try {			
		
			repository.save(pessoa);
		
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
	
	public List<Pessoa> getAll() throws OperationException{
		try {
			return (List<Pessoa>) repository.findAll();
		} catch (Exception e) {
			throw new OperationException("Pessoa not found!");
		}
	}
	
	public List<Pessoa> getAllByQuery() throws OperationException {
    	try {
    		return repository.findAllByQuery();
		} catch (Exception e) {
			throw new OperationException(e.getMessage());
		}
	}
	
	public Pessoa getFirst() throws OperationException{
		try {
			return repository.findFirstBy();
		} catch (Exception e) {
			throw new OperationException("Pessoa not found!");
		}
	}
	
	public Pessoa getLast() throws OperationException{
		try {
			return repository.findFirstByOrderByIdDesc();
		} catch (Exception e) {
			throw new OperationException("Pessoa not found!");
		}
	}
}