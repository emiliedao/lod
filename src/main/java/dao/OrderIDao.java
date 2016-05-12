package dao;

import entity.Order;

/**
 * Created by emiliedao on 5/4/16.
 */
public interface OrderIDao extends GenericIDao<Order> {
    Order findByName(String name);
}
