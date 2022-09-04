package com.simulado.service;

import java.util.List;
import java.util.Optional;

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
	
	public void delete(Pessoa pessoa) throws OperationException {	
		try {			
		
			repository.delete(pessoa);
		
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}
	
	public Optional<Pessoa> getById(Integer id) throws OperationException {
		try {
			return repository.findById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Pessoa not found!");
		}
	}

	public List<Pessoa> getAll() throws OperationException{
		try {
			return (List<Pessoa>) repository.findAll();
		} catch (Exception e) {
			throw new OperationException("Pessoa not found!");
		}
	}
	
	public boolean exists(Integer id) throws OperationException {		
		try {
			return repository.existsById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Pessoa not found!");
		}
	}
	
	public Pessoa findByName(String nome) throws OperationException {
    	
    	if (nome == null || nome.equals("")) {
    		throw new OperationException("Pessoa not found!");
		}
    	
    	try {  
    		
    		Pessoa ret = repository.findPessoaByNomePessoa(nome); 	
    	
	    	if (ret == null) {
				throw new OperationException("Pessoa not found!");
			}   	    	
		
			return ret;
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