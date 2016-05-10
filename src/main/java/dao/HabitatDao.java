package dao;

import entity.Habitat;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;


/**
 * Created by emiliedao on 5/4/16.
 */
public class HabitatDao extends GenericDaoHibernate<Habitat> implements HabitatIDao {
    public HabitatDao() {
        super(Habitat.class);
    }

    public Habitat findByLabel(String label) {
        Session s = HibernateUtils.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Habitat where label= :label");
        q.setString("label", label);
        Habitat habitat = (Habitat) q.uniqueResult();
        t.commit();
        s.close();
        return habitat;
    }
}
