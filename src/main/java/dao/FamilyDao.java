package dao;

import entity.Family;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

/**
 * Created by emiliedao on 5/4/16.
 */
public class FamilyDao extends GenericDaoHibernate<Family> implements FamilyIDao {
    public FamilyDao() {
        super(Family.class);
    }

    public Family findByName(String name) {
        Session s = HibernateUtils.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Family where name= :name order by name asc");
        q.setString("name", name);
        Family family = (Family) q.uniqueResult();
        t.commit();
        s.close();
        return family;
    }
}
