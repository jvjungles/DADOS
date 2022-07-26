package com.atividade05.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade05.entity.Departamento;
import com.atividade05.entity.Funcionario;
import com.atividade05.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	 @Autowired
    private FuncionarioRepository repository;
    
    public void save(Funcionario funcionario) {
    	repository.save(funcionario);		
	}
    
    public void delete(Funcionario funcionario) {
    	repository.delete(funcionario);		
	}
    
    public Optional<Funcionario> getById(Integer id) {
    	return repository.findById(id.longValue());		
	}
    
    public List<Funcionario> getAll() {
		return (List<Funcionario>) repository.findAll();
	}

}
