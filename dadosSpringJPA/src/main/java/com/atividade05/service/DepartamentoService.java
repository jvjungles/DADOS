package com.atividade05.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.atividade05.entity.Departamento;
import com.atividade05.exception.OperationException;
import com.atividade05.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository repository;

	public void save(Departamento departamento) throws OperationException {
		
		try {
			repository.save(departamento);
		} catch (Exception e) {
			throw new OperationException("Departamento not save!");
		}
	}

	public void delete(Integer id) throws OperationException {

		try {
			repository.delete(repository.findById(id.longValue()).get());
		} catch (NoSuchElementException e) {
			throw new OperationException("Departamento not found!");
		} catch (DataIntegrityViolationException s) {
			throw new OperationException("There is an Funcionario in this Departamento!");
		}
	}

	public Optional<Departamento> getById(Integer id) throws OperationException {

		try {
			return repository.findById(id.longValue());
		} catch (Exception e) {
			throw new OperationException("Departamento not found!");
		}
	}

	public List<Departamento> getAll() {

		try {
			return (List<Departamento>) repository.findAll();
		} catch (Exception e) {

		}
		return null;
	}
}
