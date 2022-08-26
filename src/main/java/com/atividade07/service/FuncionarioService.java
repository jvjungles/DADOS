package com.atividade07.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public List<Funcionario>  getFuncionarioAumetaSalario(Float salario) throws OperationException { 
		
		procIsValid(salario); 
		
    	try {
    		List<Funcionario> func = procAumentaSalario(salario);
    		return func;
		} catch (Exception e) {
			throw new OperationException(e.getMessage());
		}
	}
	
	private void procIsValid(Float arg) throws OperationException {		
		if (arg == null) {    			
			throw new OperationException("value not informed!");
		}		
		if (repository.findAll().isEmpty()) {
			throw new OperationException("Funcionario is empty!");
		}
	}
	
	@Transactional
	private List<Funcionario> procAumentaSalario(Float salario) throws OperationException {
		try {
			return repository.proc_aumentaSalario(salario);
		} catch (Exception e) {
			throw new OperationException("proc_aumentaSalario does not exist!");
		}
	}	
    
    public void save(Funcionario funcionario) throws OperationException {
    	try {    		
    		saveIsValid(funcionario);    		
    		repository.save(funcionario);
		} catch (Exception e) {
			throw new OperationException(e.getMessage());
		}
	}

	private void saveIsValid(Funcionario funcionario) throws OperationException {
		if (funcionario == null || funcionario.getNomeFuncionario() == null) {    			
			throw new OperationException("Nome not informed!");
		}
		if (funcionario == null || funcionario.getCpf() == null){
			throw new OperationException("CPF not informed!");				
		}  
		if (funcionario == null || funcionario.getDepartamento() == null || funcionario.getDepartamento().getId() == null){
			throw new OperationException("codDepartamento not informed!");				
		}		
		if (!departamentoRepository.findById(funcionario.getDepartamento().getId()).isPresent()) {
			throw new OperationException("Departamento not exists!");
		}
		if (repository.findFuncionarioByCpf(funcionario.getCpf()) != null) {
			throw new OperationException("Funcionario exists!");
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
			return repository.findAll();
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
    	
    	if (name == null || name.equals("")) {
    		throw new OperationException("Funcionario not found!");
		}
    	
    	Funcionario funcionario = new Funcionario(name);    	
    	Example<Funcionario> example = Example.of(funcionario);
    	
    	try {  
    		
    		List<Funcionario> ret = repository.findAll(example);    	
    	
	    	if (ret.isEmpty()) {
				throw new OperationException("Funcionario not found!");
			}   	    	
		
			return ret;
		} catch (Exception e) {
			throw new OperationException(e.getMessage());
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
    	
    	if (nomeFuncionario == null || nomeFuncionario.equals("")) {
    		throw new OperationException("Funcionario not found!");
		}
    	
    	try {
    		
			List<Funcionario> ret = repository.findFuncionarioByNomeFuncionarioAndQtdeDependente(nomeFuncionario,
					qtdeDependente);  	
    	
	    	if (ret.isEmpty()) {
				throw new OperationException("Funcionario not found!");
			}   	    	
		
			return ret;
		} catch (Exception e) {
			throw new OperationException(e.getMessage());
		}
	}
    
    public List<Funcionario> findFuncionariosbyDepartamento(Integer departamento) throws OperationException {	    	
		try {
			List<Funcionario> funcionario = repository.findFuncionariosbyDepartamento(departamento);
			
			if (funcionario.isEmpty()) {
				throw new OperationException("Funcionario not found!");
			}			
			
			return funcionario;
		} catch (Exception e) {
			throw new OperationException("Funcionario not found!");
		}
	}
    
    public Funcionario findFirstByOrderBySalarioDesc() throws OperationException {	 
		try {
			
			Funcionario funcionario = repository.findFirstByOrderBySalarioDesc();
			
			if (funcionario == null || funcionario.getId() == null) {
				throw new OperationException("Funcionario not found!");
			}			
			
			return funcionario;
		} catch (Exception e) {
			throw new OperationException(e.getMessage());
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
			
		if (name == null || name.equals("")) {
    		throw new OperationException("Funcionario not found!");
		}
    	
    	try {
    		
    		List<Funcionario> ret = repository.findByNomeLike("%"+name+"%");    	
    	
	    	if (ret.isEmpty()) {
				throw new OperationException("Funcionario not found!");
			}   	    	
		
			return ret;
		} catch (Exception e) {
			throw new OperationException(e.getMessage());
		}			
	}
    
    public List<Funcionario> findByDepartamentoSemDependentes(Long departamento) throws OperationException {	
    	
    	try {
    		
    		findByDepartamentoSemDependentesIsValid(departamento);
    		
    		List<Funcionario> ret  =  repository.findByDepartamentoSemDependentes(departamento);  
    		
    		if (ret.isEmpty()) {
    			throw new OperationException("Funcionario not found!");
			}  
    		
    		return ret;    		
		} catch (Exception e) {
			throw new OperationException(e.getMessage());
		}    	
	}

	private void findByDepartamentoSemDependentesIsValid(Long departamento) throws OperationException {
		if (departamento == null) {    			
			throw new OperationException("value not informed!");
		}				
		if (!departamentoRepository.findById(departamento).isPresent()) {
			throw new OperationException("Departamento not exists!");
		}
	} 
    
    @Transactional
    public List<Funcionario> updateAllFuncionariobyDepartamento(Long departamentoDe, Long departamentoPara) throws OperationException {	    	
				
		try {
			
			updateAllFuncionariobyDepartamentoIsValid(departamentoDe, departamentoPara);   		
    		
    		if (repository.updateAllFuncionariobyDepartamento(departamentoDe, departamentoPara) == 0) {
    			throw new OperationException("No Funcionario affected!");
			}
    		
    		return repository.findFuncionariosbyDepartamento(departamentoPara.intValue());
		} catch (NoSuchElementException e) {
			throw new OperationException("Departamento not exists!");
		}catch (Exception e) {
			throw new OperationException(e.getMessage());
		}
	}

	private void updateAllFuncionariobyDepartamentoIsValid(Long departamentoDe, Long departamentoPara) throws OperationException {
		if (departamentoDe == null || departamentoPara == null) {    			
			throw new OperationException("value not informed!");
		}
		
		if (departamentoDe == null || departamentoRepository.findById(departamentoDe).get() == null 
				|| (departamentoDe == null || departamentoRepository.findById(departamentoPara).get() == null)) {
			throw new OperationException("Departamento not exists!");
		}
	}
    
    @Transactional
    public List<Funcionario> deleteAllFuncionariobyDepartamento(Long departamento) throws OperationException {	    	
				
		try {
			
			deleteAllFuncionariobyDepartamentoIsValid(departamento);
    		
    		List<Funcionario> listDelet = repository.findFuncionariosbyDepartamento(departamento.intValue());
    		
    		if (repository.deleteAllFuncionariobyDepartamento(departamento) == 0) {
    			throw new OperationException("No Funcionario affected!");
			}
    		
    		return listDelet;
		} catch (NoSuchElementException e) {
			throw new OperationException("Departamento not exists!");
		}catch (Exception e) {
			throw new OperationException(e.getMessage());
		}
	}

	private void deleteAllFuncionariobyDepartamentoIsValid(Long departamento) throws OperationException {
		findByDepartamentoSemDependentesIsValid(departamento);
	}    
}