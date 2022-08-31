package com.atividade08.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.atividade08.entity.Departamento;
import com.atividade08.entity.Funcionario;
import com.atividade08.exception.OperationException;
import com.atividade08.repository.DepartamentoRepository;
import com.atividade08.repository.EmpresaRepository;
import com.atividade08.repository.FuncionarioRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository repository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
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
		if (departamento.getEmpresa() == null ||departamento.getEmpresa().getId() == null) {
    		throw new OperationException("codEmpresa not informed!");
		}
		if (!empresaRepository.findById(departamento.getEmpresa().getId()).isPresent()) {
			throw new OperationException("Empresa not exists!");
		}
	}
	
	//Atividade 08
	//Criar um método na classe de serviço de departamento para salvar um departamento, 
	//associar esse departamento a um funcionário e salvar esse funcionário em um mesmo controle de transação.
	
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