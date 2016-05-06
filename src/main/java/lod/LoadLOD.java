package lod;

import java.util.ArrayList;

/**
 * Created by emiliedao on 5/5/16.
 */
public class LoadLOD {

    public static ArrayList<LOD> lods = new ArrayList<LOD>();

    public static void loadAll() {
        for (LOD lod : lods) {
            lod.load();
        }
    }

    public static void main(String args[]) {
        BiologyClassLOD biologyClassLOD = new BiologyClassLOD();
//        biologyClassLOD.load();
//        biologyClassLOD.update();

//        OrderLOD orderLOD = new OrderLOD();
//        orderLOD.load();

        FamilyLOD familyLOD = new FamilyLOD();
        familyLOD.load();
    }
}
