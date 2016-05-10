package dao;

import entity.Measure;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

/**
 * Created by emiliedao on 5/4/16.
 */
public class MeasureDao extends GenericDaoHibernate<Measure> implements MeasureIDao {
    public MeasureDao() {
        super(Measure.class);
    }

    public Measure findByTitle(String title) {
        Session s = HibernateUtils.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Measure where title= :title");
        q.setString("title", title);
        Measure measure = (Measure) q.uniqueResult();
        t.commit();
        s.close();
        return measure;
    }
}
