package br.com.consultoria.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractService<T> {

    @PersistenceContext
    protected EntityManager em;

    public T persist(final T t) {
        em.persist(t);
        return t;
    }

    public T merge(final T t) {
        return em.merge(t);
    }

    public void remove(final T t) {
        em.remove(t);
    }
}
