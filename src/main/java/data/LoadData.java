package data;

import data.lod.SpeciesLOD;

import java.util.ArrayList;

/**
 * Created by emiliedao on 5/5/16.
 */
public class LoadData {

    public static ArrayList<Data> data = new ArrayList<Data>();

    public static void loadAll() {
        for (Data d : data) {
            d.load();
        }
    }

    public static void main(String args[]) {
//        BiologyClassLOD biologyClassLOD = new BiologyClassLOD();
//        biologyClassLOD.load();
//        biologyClassLOD.update();

//        OrderLOD orderLOD = new OrderLOD();
//        orderLOD.load();

//        FamilyLOD familyLOD = new FamilyLOD();
//        familyLOD.load();
//        familyLOD.update();

//        ConservationStatusData conservationStatusData = new ConservationStatusData();
//        conservationStatusData.load();

        SpeciesLOD speciesLOD = new SpeciesLOD();
//        speciesLOD.load();
        speciesLOD.update();

//        StatisticsData statisticsData = new StatisticsData();
//        statisticsData.load();

        System.exit(0);
    }
}
