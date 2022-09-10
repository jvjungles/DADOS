package com.prova.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.prova.entity.Cargo;
import com.prova.exception.OperationException;
import com.prova.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;
	
	public void save(Cargo cargo) throws OperationException {	
		try {
			repository.save(cargo);
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}
	
	public void delete(Long id) throws OperationException {
		try {
			repository.delete(
					repository.findById(id).get());
		} catch (NoSuchElementException e) {
			throw new OperationException("Cargo not found!");
		} catch (DataIntegrityViolationException s) {
			throw new OperationException(
					"Cargo nao deletado, "
					+ "existe Funcionarios cadastrados a esse Cargo!");
		}
	}
	
	public List<Cargo> getAll() throws OperationException{
		try {
			return repository.findAll();
		} catch (Exception e) {
			throw new OperationException("Cargos not found!");
		}
	}
	
	public Cargo getFirst() throws OperationException{
		try {
			return repository.findFirstBy();
		} catch (Exception e) {
			throw new OperationException("Cargo not found!");
		}
	}
	
	public Cargo getLast() throws OperationException{
		try {
			return repository.findFirstByOrderByIdDesc();
		} catch (Exception e) {
			throw new OperationException("Cargo not found!");
		}
	}	
}