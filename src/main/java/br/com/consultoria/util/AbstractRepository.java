package br.com.consultoria.util;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

@SuppressWarnings("unchecked")
public abstract class AbstractRepository<T extends AbstractEntityId> {

    @PersistenceContext
    protected EntityManager em;

    protected Class<T> entityClass;

    public AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T findBy(final Object id) {
        return em.find(entityClass, id);
    }

    public T findByOrElseThrow(final Object id) {
        final T entity = findBy(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return entity;
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

}
