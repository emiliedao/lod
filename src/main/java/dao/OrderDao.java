package dao;

import entity.Order;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

/**
 * Created by emiliedao on 5/4/16.
 */
public class OrderDao extends GenericDaoHibernate<Order> implements OrderIDao {
    public OrderDao() {
        super(Order.class);
    }

    public Order findByName(String name) {
        Session s = HibernateUtils.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Order where name= :name order by name asc");
        q.setString("name", name);
        Order order = (Order) q.uniqueResult();
        t.commit();
        s.close();
        return order;
    }
}
