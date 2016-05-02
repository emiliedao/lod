package dao;

import entity.BiologyClass;

/**
 * Created by emiliedao on 5/2/16.
 */
public class DaoFactory {

    public static BiologyClassDao getBiologyClassDao() {
        return new BiologyClassDao();
    }

}

