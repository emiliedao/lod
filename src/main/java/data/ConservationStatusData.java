package data;

import dao.ConservationStatusDao;
import dao.DaoFactory;
import entity.ConservationStatus;

/**
 * Created by emiliedao on 5/9/16.
 */
public class ConservationStatusData extends Data {


    public void load() {
        ConservationStatusDao dao = DaoFactory.getConservationStatusDao();

//        Status creation
        dao.create(new ConservationStatus("EX", "Extinct", "No known individuals remaining"));
        dao.create(new ConservationStatus("EW", "Exctinct in the wild", "Known only to survive in captivity, or as a naturalized population outside its historic range"));
        dao.create(new ConservationStatus("CR", "Critically endangered", "Extremely high risk of extinction in the wild"));
        dao.create(new ConservationStatus("EN", "Endangered", "High risk of extinction in the wild"));
        dao.create(new ConservationStatus("VU", "Vulnerable", "High risk of endangerment in the wild"));
        dao.create(new ConservationStatus("NT", "Near threatened", "Likely to become endangered in the near future"));
        dao.create(new ConservationStatus("LC", "Least concern", "Lowest risk; does not qualify for a higher risk category. Widespread and abundant taxa are included in this category."));
        dao.create(new ConservationStatus("DD", "Data deficient", " Not enough data to make an assessment of its risk of extinction"));
        dao.create(new ConservationStatus("NE", "Not evaluated", "Has not yet been evaluated against the criteria."));

    }

    public void update() {

    }
}
