package dao;

import entity.BiologyClass;

/**
 * Created by emiliedao on 5/2/16.
 */
public class BiologyClassDao extends GenericDaoHibernate<BiologyClass> implements BiologyClassIDao {

    public BiologyClassDao(Class<BiologyClass> type) {
        super(type);
    }
}
