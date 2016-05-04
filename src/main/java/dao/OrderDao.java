package dao;

import entity.Order;

/**
 * Created by emiliedao on 5/4/16.
 */
public class OrderDao extends GenericDaoHibernate<Order> implements OrderIDao {
    public OrderDao() {
        super(Order.class);
    }
}
