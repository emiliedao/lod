package test;

import dao.BiologyClassDao;
import entity.BiologyClass;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

/**
 * Created by emiliedao on 5/2/16.
 */
public class DBTest {

    private static Session session;

    /**
     * Test the creation of an instance of BiologyClass and its storage into the database
     */
    private static void testCreate() {
        Transaction t = session.beginTransaction();

//        Object creation
        BiologyClass classTest = new BiologyClass();
        classTest.setDescription("coucou");
        classTest.setName("hibou");

        session.save(classTest);
        t.commit();
    }


    /**
     * Test the method findAll() which returns the list of all the entries from a table
     */
    private static void testFindAll() {
        BiologyClassDao biologyClassDao = new BiologyClassDao();
        for (BiologyClass biologyClass : biologyClassDao.findAll(BiologyClass.class)) {
            System.out.println(biologyClass.toString());
        }
    }

    public static void main(String args[]) {
//        BasicConfigurator.configure();
        session = HibernateUtils.getSession();

//        Tests
//        testCreate();
        testFindAll();
        session.close();

    }
}
