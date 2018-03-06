package Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class DaoFacade<T> {
    
    @PersistenceContext(unitName = "KwetterPU")
    protected EntityManager em;

    private final Class<T> entityClass;

    public DaoFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
}
