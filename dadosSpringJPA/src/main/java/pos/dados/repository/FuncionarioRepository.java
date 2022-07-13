package pos.dados.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pos.dados.entity.Funcionario;

@Repository
@Transactional
public class FuncionarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(Funcionario funcionario) {
		entityManager.persist(funcionario);
		return;
	}

	public void delete(Funcionario funcionario) {
		if (entityManager.contains(funcionario))
			entityManager.remove(funcionario);
		else
			entityManager.remove(entityManager.merge(funcionario));
		return;
	}

	public void update(Funcionario funcionario) {
		entityManager.merge(funcionario);
		return;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> getAll() {
		return entityManager.createQuery("from Funcionario").getResultList();
	}

	public Funcionario getByNome(String funcionario) {
		return (Funcionario) entityManager
				.createQuery("from Funcionario where nome_funcionario = :funcionario")
				.setParameter("funcionario", funcionario)
				.getSingleResult();
	}

	public Funcionario getById(Integer id) {
		return entityManager.find(Funcionario.class, id);
	}

}
