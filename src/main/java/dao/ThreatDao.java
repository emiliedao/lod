package dao;

import entity.Threat;

/**
 * Created by emiliedao on 5/4/16.
 */
public class ThreatDao extends GenericDaoHibernate<Threat> implements ThreatIDao {
    public ThreatDao() {
        super(Threat.class);
    }
}
