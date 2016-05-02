import entity.BiologyClass;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

/**
 * Created by emiliedao on 5/2/16.
 */
public class DBTest {

    public static void main(String args[]) {
//        BasicConfigurator.configure();

        Session s = HibernateUtils.getSession();
        Transaction t = s.beginTransaction();

        BiologyClass classTest = new BiologyClass();
        classTest.setDescription("coucou");
        classTest.setName("hibou");

        s.save(classTest);
        t.commit();
        s.close();
    }
}
