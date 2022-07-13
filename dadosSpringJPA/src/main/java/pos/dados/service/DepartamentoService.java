package pos.dados.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pos.dados.entity.Departamento;

@Service
public class DepartamentoService {

    @Autowired
    EntityManager em;

    @Transactional
    public Departamento create(String nome) {
    	Departamento departamento = new Departamento(null, nome);
        em.persist(departamento);
        return departamento;
    }

}
