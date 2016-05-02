package dao;

import utils.HibernateUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by emiliedao on 5/2/16.
 */
public abstract class GenericDaoHibernate<T> implements GenericIDao<T> {

    private Class<T> type;

    public GenericDaoHibernate(Class<T> type) {
        this.type = type;
    }

    public void create(T object) {
        HibernateUtils.getSession().save(object);
    }

    public T findById(T id) {
        return (T)HibernateUtils.getSession().get(type, (Serializable)id);
    }

    public void update(T object) {
        HibernateUtils.getSession().update(object);
    }

    public void delete(T object) {
        HibernateUtils.getSession().delete(object);
    }

    public List<T> findAll() {
        return null;
    }


}
