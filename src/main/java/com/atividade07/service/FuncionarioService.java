package com.atividade07.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.atividade07.entity.Funcionario;
import com.atividade07.exception.OperationException;
import com.atividade07.repository.DepartamentoRepository;
import com.atividade07.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
    private FuncionarioRepository repository;
	
	@Autowired
    private DepartamentoRepository departamentoRepository;
	
	@Transactional
	public List<Funcionario> getFuncionarioAumetaSalario(Integer arg) throws OperationException {    	
    	try {
    		return repository.proc_aumentaSalario(arg);
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public void save(Funcionario funcionario) throws OperationException {    	
    	try {
    		
    		if (repository.findFuncionarioByCpf(funcionario.getCpf()) != null) {
    			throw new OperationException("Funcionario exists!");
			}   		
    		
    		repository.save(funcionario);
    		
		} catch (DataIntegrityViolationException e) {
			
			if (e.getMessage().contains("cpf")) {
				throw new OperationException("Funcionario - CPF nao informado!");
			}else {
				throw new OperationException("Departamento not found!");
			}
			
		} catch (Exception e) {
			throw new OperationException("Funcionario - CPF exists!");
		}
	}
    
    public void delete(Integer id) throws OperationException {    	
    	try {
			repository.delete(
					repository.findById(id.longValue()).get()
			);
		} catch (NoSuchElementException e) {
			throw new OperationException("Funcionario not found!");
		} catch (NullPointerException e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public Optional<Funcionario> getById(Integer id) throws OperationException {    	
    	try {
    		return repository.findById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public Funcionario findByCpf(String cpf) throws OperationException {    	   	    	
		try {
			return repository.findFuncionarioByCpf(cpf);
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> getAll() throws OperationException {		
		try {
			return (List<Funcionario>) repository.findAll();
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public boolean exists(Integer id) throws OperationException {		
		try {
			return repository.existsById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> findByName(String name) throws OperationException {    	
    	if (name.equals("")) {
    		throw new OperationException("Funcionario not found!");
		}
		
    	Funcionario funcionario = new Funcionario(name);    	
    	Example<Funcionario> example = Example.of(funcionario);
    	    	
		try {
			return repository.findAll(example);
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> findBySalario(Double salario) throws OperationException {    	   	    	
		try {
			return repository.findFuncionarioBySalario(salario);
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> findAllByQuery() throws OperationException {	    	
		try {
			return repository.findAllByQuery();
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> findFuncionarioByNomeFuncionarioAndQtdeDependente(
    		String nomeFuncionario, Integer qtdeDependente) throws OperationException {	    	
		try {
			return repository.findFuncionarioByNomeFuncionarioAndQtdeDependente(nomeFuncionario, qtdeDependente);
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> findFuncionariosbyDepartamento(Integer departamento) throws OperationException {	    	
		try {
			return repository.findFuncionariosbyDepartamento(departamento);
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public Funcionario findFirstByOrderBySalarioDesc() throws OperationException {	    	
		try {
			return repository.findFirstByOrderBySalarioDesc();
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> findFirst3ByOrderBySalarioDesc() throws OperationException {	    	
		try {
			return repository.findFirst3ByOrderBySalarioDesc();
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> findFuncionarioByNoDependentes() throws OperationException {	    	
		try {
			return repository.findFuncionarioByNoDependentes();
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> findFuncionarioBySalarioValue(Double salario) throws OperationException {	    	
		try {
			return repository.findFuncionarioBySalarioValue(salario);
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> findFuncionarioBySalarioValueNq(Double salario) throws OperationException {	    	
		try {
			return repository.findFuncionarioBySalarioValueNq(salario);
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> findByDependentes(Integer qtdeDependente) throws OperationException {	    	
		try {
			return repository.findByDependentes(qtdeDependente);
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> findByNomeLike(String name) throws OperationException {	    	
		try {
			return repository.findByNomeLike("%"+name+"%");
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public List<Funcionario> findByDepartamentoSemDependentes(Long departamento) throws OperationException {	    	
		try {
			return repository.findByDepartamentoSemDependentes(departamento);
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    @Transactional
    public List<Funcionario> updateAllFuncionariobyDepartamento(Long departamentoDe, Long departamentoPara) throws OperationException {	    	
				
		try {
    		
    		if (departamentoRepository.findById(departamentoDe) == null) {
    			throw new OperationException("Departamento not exists!");
			}   		
    		
    		if (repository.updateAllFuncionariobyDepartamento(departamentoDe, departamentoPara) == 0) {
    			throw new OperationException("No Funcionario affected!");
			}
    		
    		return repository.findFuncionariosbyDepartamento(departamentoPara.intValue());
    		
    		
		} catch (Exception e) {
			throw new OperationException("Update not execute!");
		}
	}
}