package com.simulado.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.simulado.entity.Departamento;
import com.simulado.entity.Funcionario;
import com.simulado.exception.OperationException;
import com.simulado.repository.DepartamentoRepository;
import com.simulado.repository.FuncionarioRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository repository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public void save(Departamento departamento) throws OperationException {		
		try {			
		
			isValid(departamento);
			repository.save(departamento);
		
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}

	private void isValid(Departamento departamento) throws OperationException {
		if (departamento == null ||departamento.getNome_departamento() == null) {
    		throw new OperationException("Nome not informed!");
		}		
	}
	
	@Transactional
	public void saveDepartamentoAndFuncionario(Departamento departamento, Funcionario funcionario) throws OperationException {		
		try {			
		
			saveDepartamentoAndFuncionarioIsValid(funcionario);
						
			repository.save(departamento);
			funcionario.setDepartamento(departamento);
			funcionarioRepository.save(funcionario);		
		} catch (Exception e) {			
			throw new OperationException(e.getMessage());			
		}		
	}
	
	private void saveDepartamentoAndFuncionarioIsValid(Funcionario funcionario) throws OperationException {
		if (funcionario == null || funcionario.getNomeFuncionario() == null) {    			
			throw new OperationException("Nome not informed!");
		}
		if (funcionario == null || funcionario.getCpf() == null){
			throw new OperationException("CPF not informed!");				
		}  
		if (funcionarioRepository.findFuncionarioByCpf(funcionario.getCpf()) != null) {
			throw new OperationException("Funcionario exists!");
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
			
			if (depertamento == null || depertamento.getId() == null) {
				throw new OperationException("Departamento not found!");
			}
			
			return depertamento;
		} catch (Exception e) {
			throw new OperationException(e.getMessage());
		}
	}
}