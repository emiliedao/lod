package dao;

import org.hibernate.Query;
import org.hibernate.Session;
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

    public T findById(int id) {
        return (T)HibernateUtils.getSession().get(type, id);
    }

    public T findById(String id) {
        return (T)HibernateUtils.getSession().get(type, id);
    }

    public void update(T object) {
        HibernateUtils.getSession().update(object);
    }

    public void delete(T object) {
        HibernateUtils.getSession().delete(object);
    }

    public List<T> findAll(Class<T> type) {
        Session s = HibernateUtils.getSession();
        List l = s.createQuery("from " + type.getName()).list();
        s.close();
        return l;
    }


}
