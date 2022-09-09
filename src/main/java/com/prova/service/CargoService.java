package com.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	
}