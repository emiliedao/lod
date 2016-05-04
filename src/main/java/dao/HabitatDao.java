package dao;

import entity.Habitat;

/**
 * Created by emiliedao on 5/4/16.
 */
public class HabitatDao extends GenericDaoHibernate<Habitat> implements HabitatIDao {
    public HabitatDao() {
        super(Habitat.class);
    }
}
