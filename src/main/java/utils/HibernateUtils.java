package utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by emiliedao on 5/2/16.
 *
 * This class is used to create and manage the SessionFactory, whose role is to parse Hibernate configuration file, connect to the database and provide Sessions whenever needed.
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory;

    // Create a unique instance of SessionFactory using hibernate.cfg.xml
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException("Problème de configuration : " + e.getMessage(), e);
        }
    }

    // Return a Hibernate session whenever called
    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}
