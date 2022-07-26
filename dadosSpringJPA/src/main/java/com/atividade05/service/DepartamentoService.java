package com.atividade05.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade05.entity.Departamento;
import com.atividade05.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository repository;
    
    public void save(Departamento departamento) {
    	repository.save(departamento);		
	}
    
    public void delete(Departamento departamento) {
    	repository.delete(departamento);		
	}
    
    public Optional<Departamento> getById(Integer id) {
    	return repository.findById(id.longValue());		
	}
    
    public List<Departamento> getAll() {
		return (List<Departamento>) repository.findAll();
	}

}
