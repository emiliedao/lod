package dao;

import entity.BiologyClass;

import java.util.Collection;
import java.util.List;

/**
 * Created by emiliedao on 5/2/16.
 */
public class BiologyClassDao extends GenericDaoHibernate<BiologyClass> implements BiologyClassIDao {

    public BiologyClassDao() {
        super(BiologyClass.class);
    }

}
