import dao.*;
import entity.BiologyClass;
import entity.Family;
import entity.Order;
import entity.Species;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.spi.NaturalIdUniqueKeyBinder;
import utils.HibernateUtils;

import java.util.ArrayList;

/**
 * Created by emiliedao on 5/2/16.
 */
public class DBTest {

    private static BiologyClassDao biologyClassDao = DaoFactory.getBiologyClassDao();
    private static OrderDao orderDao = DaoFactory.getOrderDao();
    private static FamilyDao familyDao = DaoFactory.getFamilyDao();
    private static SpeciesDao speciesDao = DaoFactory.getSpeciesDao();

    /**
     * Test the creation of an instance of BiologyClass and its storage into the database
     */
    private static void testCreateClass() {

//        Object creation
        BiologyClass classTest = new BiologyClass();
        classTest.setName("new");
        classTest.setDescription("class");

//        session.save(classTest);
        BiologyClassDao classDao = new BiologyClassDao();
        classDao.create(classTest);
    }

    private static void testCreateOrder() {

        BiologyClass mammals = biologyClassDao.findById(1);
        Order order = new Order("dog order", "i love bones", null, mammals);
        orderDao.create(order);
    }

    /**
     * Test the method findById() which returns the object corresponding to the id
     */
    private static void testFindById() {
        BiologyClass biologyClass = biologyClassDao.findById(1);

        try {
            System.out.println(biologyClass.toString());
        }

        catch (NullPointerException e) {
            System.err.println("No class found");
        }
    }

    /**
     * Test the method findAll() which returns the list of all the entries from a table
     */
    private static void testFindAll() {
        for (BiologyClass biologyClass : biologyClassDao.findAll(BiologyClass.class)) {
            System.out.println(biologyClass.toString());
        }
    }

    /**
     * Test the method update() which updates an object from the database
     */
    private static void testUpdate() {
        BiologyClass biologyClass = biologyClassDao.findById(1);
        biologyClass.setDescription("Mammals");
        biologyClassDao.update(biologyClass);
    }

    /**
     * Test the method delete() which deletes an object from the database
     */
    private static void testDelete() {
        BiologyClass biologyClass = biologyClassDao.findById(2);
        biologyClassDao.delete(biologyClass);
    }

    /**
     * Test if the list of orders can be retrieved from the biology class
     */
    private static void testFindOrders() {
        BiologyClass biologyClass = biologyClassDao.findById(1);
        System.out.println(biologyClass.toString());
    }

    private static void testFindSpeciesByNameAndFamily() {
        Family family = familyDao.findById(17);
        System.out.println(family.toString());

        ArrayList<Species> species = (ArrayList<Species>) speciesDao.findByLetterAndFamily('E', family);

        for (Species s : species) {
            System.out.println(s.toString());
        }
    }

    public static void main(String args[]) {
//        Tests
//        testCreateClass();
//        testFindById();
//        testFindAll();
//        testUpdate();
//        testDelete();
//        testCreateOrder();
//        testFindOrders();
        testFindSpeciesByNameAndFamily();
    }
}
