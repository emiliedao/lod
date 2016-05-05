package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
        Session s = HibernateUtils.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.save(object);
        t.commit();
        s.close();
    }

    public T findById(int id) {
        Session s = HibernateUtils.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        T object = (T)s.get(type, id);
        t.commit();
        s.close();
        return object;
    }

    public T findById(String id) {
        Session s = HibernateUtils.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        T object = (T)s.get(type, id);
        t.commit();
        s.close();
        return object;
    }

    public void update(T object) {
        Session s = HibernateUtils.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.update(object);
        t.commit();
        s.close();
    }

    public void delete(T object) {
        Session s = HibernateUtils.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.delete(object);
        t.commit();
        s.close();
    }

    public List<T> findAll(Class<T> type) {
        Session s = HibernateUtils.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        List l = s.createQuery("from " + type.getName()).list();
        t.commit();
        s.close();
        return l;
    }


}
