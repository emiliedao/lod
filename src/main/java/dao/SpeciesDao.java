package dao;

import entity.Family;
import entity.Species;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.List;

/**
 * Created by emiliedao on 5/4/16.
 */
public class SpeciesDao extends GenericDaoHibernate<Species> implements SpeciesIDao {
    public SpeciesDao() {
        super(Species.class);
    }


    public Species findByName(String name) {
        Session s = HibernateUtils.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Species where name= :name order by name asc");
        q.setString("name", name);
        Species species = (Species) q.uniqueResult();
        t.commit();
        s.close();
        return species;
    }

    public List<Species> findByFamily(Family family) {
        Session s = HibernateUtils.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Species where family=:family order by name asc");
        q.setParameter("family", family);
        List<Species> species = q.list();
        t.commit();
        s.close();
        return species;
    }

    public List<Species> findByLetterAndFamily(Character letter, Family family) {
        Session s = HibernateUtils.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Species where name like:name and family=:family order by name asc");
        q.setString("name", letter + "%");
        q.setParameter("family", family);
        List<Species> species = q.list();
        t.commit();
        s.close();
        return species;
    }

    public int countByLetterAndFamily(Character letter, Family family) {
        Session s = HibernateUtils.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("select count (*) from Species where name like:name and family=:family");
        q.setString("name", letter + "%");
        q.setParameter("family", family);
        int count = Integer.parseInt(q.uniqueResult().toString());
        t.commit();
        s.close();
        return count;
    }
}
