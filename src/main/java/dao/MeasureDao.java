package dao;

import entity.Measure;

/**
 * Created by emiliedao on 5/4/16.
 */
public class MeasureDao extends GenericDaoHibernate<Measure> implements MeasureIDao {
    public MeasureDao() {
        super(Measure.class);
    }
}
