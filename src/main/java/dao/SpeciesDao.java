package dao;

import entity.Species;

/**
 * Created by emiliedao on 5/4/16.
 */
public class SpeciesDao extends GenericDaoHibernate<Species> implements SpeciesIDao {
    public SpeciesDao() {
        super(Species.class);
    }
}
