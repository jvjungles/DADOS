package com.simulado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulado.entity.Gravacao;
import com.simulado.exception.OperationException;
import com.simulado.repository.GravacaoRepository;

@Service
public class GravacaoService {

	@Autowired
	private GravacaoRepository repository;
	
	public void save(Gravacao gravacao) throws OperationException {	
		try {			
		
			repository.save(gravacao);
		
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}
	
	public void delete(Gravacao gravacao) throws OperationException {	
		try {			
		
			repository.delete(gravacao);
		
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}
	
	public Optional<Gravacao> getById(Integer id) throws OperationException {
		try {
			return repository.findById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Gravacao not found!");
		}
	}

	public List<Gravacao> getAll() throws OperationException{
		try {
			return (List<Gravacao>) repository.findAll();
		} catch (Exception e) {
			throw new OperationException("Gravacao not found!");
		}
	}
	
	public boolean exists(Integer id) throws OperationException {		
		try {
			return repository.existsById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Gravacao not found!");
		}
	}
}