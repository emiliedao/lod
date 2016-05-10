package dao;

import entity.Measure;

/**
 * Created by emiliedao on 5/4/16.
 */
public interface MeasureIDao extends GenericIDao<Measure> {
    Measure findByTitle(String title);
}
