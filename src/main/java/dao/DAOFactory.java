package dao;

/**
 * Created by emiliedao on 5/2/16.
 */
public class DaoFactory {

    public static BiologyClassDao getBiologyClassDao() {
        return new BiologyClassDao();
    }

    public static ConservationStatusDao getConservationStatusDao() {
        return new ConservationStatusDao();
    }

    public static CountryDao getCountryDao() { return new CountryDao(); }

    public static FamilyDao getFamilyDao() { return new FamilyDao(); }

    public static HabitatDao getHabitatDao() { return new HabitatDao(); }

    public static MeasureDao getMeasureDao() { return new MeasureDao(); }

    public static OrderDao getOrderDao() { return new OrderDao(); }

    public static SpeciesDao getSpeciesDao() { return new SpeciesDao(); }

    public static ThreatDao getThreatDao() { return new ThreatDao(); }
}

