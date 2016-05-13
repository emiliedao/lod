package dao;

import entity.Family;

/**
 * Created by emiliedao on 5/4/16.
 */
public interface FamilyIDao extends GenericIDao<Family> {
    Family findByName(String name);
}
