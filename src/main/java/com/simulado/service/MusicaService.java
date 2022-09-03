package com.simulado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulado.entity.Musica;
import com.simulado.exception.OperationException;
import com.simulado.repository.MusicaRepository;

@Service
public class MusicaService {

	@Autowired
	private MusicaRepository repository;
	
	public void save(Musica musica) throws OperationException {	
		try {			
		
			repository.save(musica);
		
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}
	
	public void delete(Musica musica) throws OperationException {	
		try {			
		
			repository.delete(musica);
		
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}
	
	public Optional<Musica> getById(Integer id) throws OperationException {
		try {
			return repository.findById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Musica not found!");
		}
	}

	public List<Musica> getAll() throws OperationException{
		try {
			return (List<Musica>) repository.findAll();
		} catch (Exception e) {
			throw new OperationException("Musica not found!");
		}
	}
	
	public boolean exists(Integer id) throws OperationException {		
		try {
			return repository.existsById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Musica not found!");
		}
	}
}