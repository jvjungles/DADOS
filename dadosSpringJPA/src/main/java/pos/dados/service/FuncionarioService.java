package pos.dados.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pos.dados.entity.Departamento;
import pos.dados.entity.Funcionario;

@Service
public class FuncionarioService {

    @Autowired
    EntityManager em;

    @Transactional
    public Funcionario create(Integer cod_funcionario, 
    		String nome_funcionario, Integer qtde_dependente, 
    		Double salario, String cargo, Integer departamentoId) {
    	
    	Departamento departamento = new Departamento();
    	departamento.setCod_departamento(departamentoId);
    	
    	Funcionario funcionario = new Funcionario(cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, departamento);
        em.persist(funcionario);
        return funcionario;
    }

}
