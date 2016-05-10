package data;

import dao.BiologyClassDao;
import dao.DaoFactory;
import entity.BiologyClass;

/**
 * Created by emiliedao on 5/5/16.
 */
public class BiologyClassLOD extends LOD {

    private String name = "Mammal";

    public void loadBiologyClass() {

//        Creation of biology class Mammal
        BiologyClass mammals = new BiologyClass();
        mammals.setName(name);
        mammals.setDescription(getDbpediaDescription(name));
        mammals.setImage(getBBCImage("src/main/resources/rdf/Mammal.rdf"));

        BiologyClassDao biologyClassDao = DaoFactory.getBiologyClassDao();
        biologyClassDao.create(mammals);
    }


    public void load() {
        loadBiologyClass();
    }

    public void update() {
        BiologyClassDao biologyClassDao = DaoFactory.getBiologyClassDao();
        BiologyClass mammal = biologyClassDao.findById(1);
        mammal.setImage(getBBCImage("src/main/resources/rdf/Mammal.rdf"));
        biologyClassDao.update(mammal);

    }

}
