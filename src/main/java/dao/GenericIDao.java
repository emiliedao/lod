package dao;

import javax.persistence.Table;
import java.util.List;

/**
 * Created by emiliedao on 5/2/16.
 */
public interface GenericIDao<T> {

    /**
     * Persist the object into the database
     * @param object the new instance
     */
    void create(T object);

    /**
     * Retrieve an object that was previously persisted to the database using its id
     * @param id the primary key of the object
     * @return the object corresponding to the given id
     */
    T findById(T id);

    /**
     * Save changes made to a persistent object
     * @param object
     */
    void update(T object);

    /**
     * Remove an object from persistent storage in the database
     * @param object
     */
    void delete(T object);

    /**
     *
     * @return
     */
    List<T> findAll(Class<T> type);


}
