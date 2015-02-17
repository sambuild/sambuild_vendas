package br.com.sambuild.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.sambuild.interceptor.Transactional;

public class Dao<T> implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8355276728452309544L;

	private final Class<T> classe;

    @Inject
    private EntityManager manager;

    public Dao(Class<T> classe) {
	this.classe = classe;
    }

    /**
     * <p>
     * This method is responsible for save a new object in database.
     * </p>
     * <p>
     * For use this method is necessary first open the transition, for this use
     * the annotation {@link Transactional}
     * </p>
     * 
     * @param instance
     *            Object for persist in database
     */
    public void saveNew(T instance) {
	manager.persist(instance);
    }

    /**
     * <p>
     * This method is responsible for remove a object in database.
     * </p>
     * <p>
     * For use this method is necessary first open the transition, for this use
     * the annotation {@link Transactional}
     * </p>
     * 
     * @param instance
     *            Object for be removed of database
     */
    public void remove(T instance) {
	manager.remove(manager.merge(instance));
    }

    /**
     * <p>
     * This method is responsible for amend a object in database.
     * </p>
     * <p>
     * For use this method is necessary first open the transition, for this use
     * the annotation {@link Transactional}
     * </p>
     * 
     * @param instace
     *            Object for be amended on database
     */
    public void amend(T instace) {
	instace = manager.merge(instace);
    }

    public List<T> listAll() {
	CriteriaQuery<T> query = manager.getCriteriaBuilder().createQuery(
		classe);
	query.select(query.from(classe));

	List<T> lista = manager.createQuery(query).getResultList();

	return lista;
    }

    public T findById(Long id) {
	T instancia = manager.find(classe, id);
	return instancia;
    }

    public int countAll() {
	long result = (Long) manager.createQuery(
		"select count(n) from " + classe.getName() + " n")
		.getSingleResult();

	return (int) result;
    }

    public List<T> listByPage(int firstResult, int maxResults) {
	CriteriaQuery<T> query = manager.getCriteriaBuilder().createQuery(
		classe);
	query.select(query.from(classe));

	List<T> lista = manager.createQuery(query).setFirstResult(firstResult)
		.setMaxResults(maxResults).getResultList();
	return lista;
    }

    public List<T> listUsingFilter(Map<String, Object> filters,
	    int firstResult, int maxResults) {
	CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();

	CriteriaQuery<T> query = criteriaBuilder.createQuery(classe);

	Root<T> pet = query.from(classe);
	for (String key : filters.keySet()) {

	    String value = String.format("%%%s%%", filters.get(key));
	    query.where(criteriaBuilder.like(pet.<String> get(key), value));
	}
	
	List<T> lista = manager.createQuery(query).setFirstResult(firstResult)
		.setMaxResults(maxResults).getResultList();

	return lista;
    }

}
