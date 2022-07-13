package pos.dados.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pos.dados.entity.Departamento;

@Repository
@Transactional
public class DepartamentoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(Departamento departamento) {
		entityManager.persist(departamento);
		return;
	}

	public void delete(Departamento departamento) {
		if (entityManager.contains(departamento))
			entityManager.remove(departamento);
		else
			entityManager.remove(entityManager.merge(departamento));
		return;
	}

	public void update(Departamento departamento) {
		entityManager.merge(departamento);
		return;
	}

	@SuppressWarnings("unchecked")
	public List<Departamento> getAll() {
		return entityManager.createQuery("from Departamento").getResultList();
	}

	public Departamento getByNome(String departamento) {
		return (Departamento) entityManager
				.createQuery("from Departamento where nome_departamento = :departamento")
				.setParameter("departamento", departamento)
				.getSingleResult();
	}

	public Departamento getById(long id) {
		return entityManager.find(Departamento.class, id);
	}

}
