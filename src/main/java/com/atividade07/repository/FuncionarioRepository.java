package com.atividade07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.atividade07.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	@Procedure("proc_aumentaSalario")
	List<Funcionario> proc_aumentaSalario(Integer arg);
	
	Funcionario findFuncionarioByCpf(String cpf);
	
	List<Funcionario> findFuncionarioBySalario(Double salario);
	
	@Query("select f from Funcionario f")
	List<Funcionario> findAllByQuery();
	
	List<Funcionario> findFuncionarioByNomeFuncionarioAndQtdeDependente(String nomeFuncionario, Integer qtdeDependente);
	
	@Query("select f from Funcionario f where id_departamento = ?1")
	List<Funcionario> findFuncionariosbyDepartamento(Integer departamento);
		
	Funcionario findFirstByOrderBySalarioDesc();
	
	List<Funcionario> findFirst3ByOrderBySalarioDesc();
	
	@Query("select f from Funcionario f where qtdeDependente = 0 order by nomeFuncionario")
	List<Funcionario> findFuncionarioByNoDependentes();
	
	@Query("select f from Funcionario f where salario >= ?1 order by salario desc")
	List<Funcionario> findFuncionarioBySalarioValue(Double salario);
	
	@Query(value = "select * from Funcionario where salario >= ?1 order by salario desc", nativeQuery = true)
	List<Funcionario> findFuncionarioBySalarioValueNq(Double salario);	
	
	@Query(name = "Funcionario.byDependentes")
	List<Funcionario> findByDependentes(Integer qtdeDependente);
	
	@Query(name = "Funcionario.byNomeLike")
	List<Funcionario> findByNomeLike(@Param("nomeFuncionario") String nomeFuncionario);
	
	@Query("select f from Funcionario f"
    	+ " where f.departamento.id = :departamento and f.qtdeDependente = 0") 
    List<Funcionario> findByDepartamentoSemDependentes(@Param("departamento") Long departamento);
}