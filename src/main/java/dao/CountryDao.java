package dao;

import entity.Country;

/**
 * Created by emiliedao on 5/4/16.
 */
public class CountryDao extends GenericDaoHibernate<Country> implements CountryIDao {
    public CountryDao() {
        super(Country.class);
    }
}
