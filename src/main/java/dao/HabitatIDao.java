package dao;

import entity.Habitat;

/**
 * Created by emiliedao on 5/4/16.
 */
public interface HabitatIDao extends GenericIDao<Habitat> {
    Habitat findByLabel(String label);
}
