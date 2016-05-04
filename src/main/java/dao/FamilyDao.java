package dao;

import entity.Family;

/**
 * Created by emiliedao on 5/4/16.
 */
public class FamilyDao extends GenericDaoHibernate<Family> implements FamilyIDao {
    public FamilyDao() {
        super(Family.class);
    }
}
