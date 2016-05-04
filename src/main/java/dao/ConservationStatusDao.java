package dao;

import entity.ConservationStatus;

/**
 * Created by emiliedao on 5/4/16.
 */
public class ConservationStatusDao extends GenericDaoHibernate<ConservationStatus> implements ConservationStatusIDao {

    public ConservationStatusDao() {
        super(ConservationStatus.class);
    }
}
