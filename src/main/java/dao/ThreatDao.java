package dao;

import entity.Threat;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

/**
 * Created by emiliedao on 5/4/16.
 */
public class ThreatDao extends GenericDaoHibernate<Threat> implements ThreatIDao {
    public ThreatDao() {
        super(Threat.class);
    }

    public Threat findByTitle(String title) {
        Session s = HibernateUtils.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Threat where title= :title");
        q.setString("title", title);
        Threat threat = (Threat) q.uniqueResult();
        t.commit();
        s.close();
        return threat;
    }
}
