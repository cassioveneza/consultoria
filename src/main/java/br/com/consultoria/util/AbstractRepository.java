package br.com.consultoria.util;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

@SuppressWarnings("unchecked")
public class AbstractRepository<T extends AbstractEntityId, Q extends EntityPathBase<T>> {

    @PersistenceContext
    protected EntityManager em;

    protected Q entityPath;

    private Class<T> entityClass;

    public AbstractRepository(final Q entityPath) {
        entityClass = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        this.entityPath = entityPath;
    }

    protected JPQLQuery from() {
        return from(entityPath);
    }

    protected JPQLQuery from(final Q entityPath) {
        return createQuery().from(entityPath);
    }

    protected JPQLQuery createQuery() {
        return new JPAQuery(em);
    }

    public T findBy(final Long id) {
        return em.find(entityClass, id);
    }

    public T findByOrElseThrow(final Long id) {
        final T entity = findBy(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return entity;
    }

    public List<T> findAll() {
        return from().list(entityPath);
    }
}
