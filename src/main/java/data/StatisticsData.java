package data;

import dao.ConservationStatusDao;
import dao.DaoFactory;
import dao.SpeciesDao;
import entity.ConservationStatus;
import entity.Species;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.net.URL;
import java.util.*;

/**
 * Created by emiliedao on 5/26/16.
 */
public class StatisticsData extends Data {
    public void load() {

//        String speciesByStatus = getSpeciesByStatus();
//        System.out.println(speciesByStatus);

        ConservationStatusDao conservationStatusDao = DaoFactory.getConservationStatusDao();
        List<ConservationStatus> statusList = conservationStatusDao.findAll(ConservationStatus.class);
//        System.out.println(statusList.get(0).getLabel());
        String speciesByCountry = getSpeciesByCountry(statusList.get(0));
        System.out.println(speciesByCountry);

    }

    public void update() {

    }



    /**
     * Build the string for pie chart presenting the percentage of species by conservation status
     * @return the string containing the data
     */
    private String getSpeciesByStatus() {

        SpeciesDao speciesDao = DaoFactory.getSpeciesDao();
        ConservationStatusDao conservationStatusDao = DaoFactory.getConservationStatusDao();
        List<ConservationStatus> status = conservationStatusDao.findAll(ConservationStatus.class);

//        Build string data
        String speciesByStatus = "[";
        for (ConservationStatus s : status) {
            int count = speciesDao.countByConservationStatus(s);
            int total = speciesDao.countAll();
            float percentage = count * 100 / total;
            String label = s.getLabel();

            speciesByStatus += "{ name: '" + label + "', "
                    + "y: " + percentage + ", "
                    + "color: '" + chooseColor(label) + "' }";
            if (status.indexOf(s) != status.size() - 1) {
                speciesByStatus += ",";
            }
        }
        speciesByStatus += "]";
        return  speciesByStatus;
    }

    private String chooseColor(String status) {
        String color = "";
        if (status.equals("Critically endangered")) {
            color = "rgb(255,116,116)";
        }

        else if (status.equals("Endangered")) {
            color = "rgb(255,117,153)";
        }

        else if (status.equals("Vulnerable")) {
            color = "#f7a35c";
        }

        else if (status.equals("Near threatened")) {
            color = "#e4d354";
        }

        else if (status.equals("Least concern")) {
            color = "#90ed7d";
        }

        else if (status.equals("Extinct in the wild")) {
            color = "#7cb5ec";
        }

        else if (status.equals("Extinct")) {
            color = "#8085e9";
        }

        else if (status.equals("Data deficient")) {
            color = "#434348";
        }

        else {
            color = "#e7e7e7";
        }

        return color;

    }

    /**
     * Build a string containing the number of species by country, having the same conservations status
     * @param status the conservation status
     * @return the data string
     */
    private String getSpeciesByCountry(ConservationStatus status) {
        HashMap<String, Integer> countByCountry = new HashMap<String, Integer>();

        SpeciesDao speciesDao = DaoFactory.getSpeciesDao();
        List<Species> species = speciesDao.findByConservationStatus(status);

//        Get data
        for (Species s : species) {
            ArrayList<String> countries = getCountries(s);
//            Count species by country
            for (String country : countries) {
                int count = (countByCountry.get(country) != null) ? (countByCountry.get(country) + 1) : 1;
                countByCountry.put(country, count);
            }
        }

//        Build data string
        String speciesByCountry = "[";

        Iterator<Map.Entry<String, Integer>> it = countByCountry.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            speciesByCountry += "['" + entry.getKey() + "', " + entry.getValue() + "]";
//            Not the last element
            if (it.hasNext()) {
                speciesByCountry += ", ";
            }
        }
        speciesByCountry += "]";

        return speciesByCountry;
    }

    private ArrayList<String> getCountries(Species species) {
        String url = null;
        String formattedName = species.getScientificName().replace(" ", "%20");
        url = "http://apiv3.iucnredlist.org/api/v3/species/countries/name/" + formattedName + "?token=72a46a72cd71144d445d6ce0d8ccb67709db20ca995dbe9635155d7ec6284207";
        System.out.println(url);

        ArrayList<String> countries = new ArrayList<String>();

        try {
            String jsonString = IOUtils.toString(new URL(url));

            JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(jsonString);
            JSONArray result = (JSONArray) jsonObject.get("result");

            for (int i = 0; i < result.size(); i++) {
                JSONObject o = (JSONObject) result.get(i);
                String name = (String)o.get("country");
                countries.add(name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return countries;
    }
}
