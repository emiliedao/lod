package data.lod;

import dao.*;
import entity.*;
import org.apache.commons.io.IOUtils;
import org.apache.jena.query.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by emiliedao on 5/9/16.
 */
public class SpeciesLOD extends LOD {

    public String IUCN_Token = "72a46a72cd71144d445d6ce0d8ccb67709db20ca995dbe9635155d7ec6284207";

    /**
     * Retrieve from DPpedia all the species belonging to a family and store them into the database
     *
     * @param family the family from which the species are loaded
     */
    public void loadSpecies(Family family) {
        String speciesQuery = "PREFIX dbo: <http://dbpedia.org/ontology/>\n" +
                "PREFIX dbp: <http://dbpedia.org/property/>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "\n" +
                "SELECT DISTINCT ?name ?scientificName ?description ?comment ?thumbnail ?conservationStatus\n" +
                "WHERE \n" +
                "{\n" +
                "?species dbo:family <http://dbpedia.org/resource/" + family.getName() + "> ;\n" +
                " dbp:name ?name ;\n" +
                " dbp:binomial ?scientificName ;\n" +
                " dbo:abstract ?description ;\n" +
                " rdfs:comment ?comment ;\n" +
                " dbo:thumbnail ?thumbnail ;\n" +
                " dbo:conservationStatus ?conservationStatus .\n" +
                "\n" +
                "FILTER (\n" +
                "  langMatches(lang(?description),\"en\") &&\n" +
                "  langMatches(lang(?comment),\"en\")\n" +
                ")\n" +
                "}\n";

        Query query = QueryFactory.create(speciesQuery);
        QueryExecution qe = QueryExecutionFactory.sparqlService(sparqlEndpoint, query);

        try {

            ResultSet results = qe.execSelect();
//            ResultSetFormatter.out(System.out, results, query);
            SpeciesDao speciesDao = DaoFactory.getSpeciesDao();
            ConservationStatusDao conservationStatusDao = DaoFactory.getConservationStatusDao();

            for (; results.hasNext(); ) {
                QuerySolution soln = results.nextSolution();

                Species species = new Species();
                species.setName(soln.getLiteral("name").getString());
                species.setScientificName(soln.getLiteral("scientificName").getString());
                species.setDescription(soln.getLiteral("description").toString());
                species.setComment(soln.getLiteral("comment").toString());
                species.setImage(soln.getResource("thumbnail").toString());

                String status = soln.getLiteral("conservationStatus").toString();
                ConservationStatus conservationStatus = conservationStatusDao.findById(status);
                if (conservationStatus != null) {
                    species.setConservationStatus(conservationStatus);
                }

                species.setFamily(family);

                speciesDao.create(species);
                System.out.println(family.getName() + " : " + species.getName());
            }

        } finally {
//      Important - free up resources used running the query
            qe.close();

        }
    }

    public void loadHabitats(Species species) {
        String url = null;
        String formattedName = species.getScientificName().replace(" ", "%20");
        url = "http://apiv3.iucnredlist.org/api/v3/habitats/species/name/" + formattedName + "?token=" + IUCN_Token;

        System.out.println(species.getName() + " " + url);

        try {
            String jsonString = IOUtils.toString(new URL(url));

            JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(jsonString);
            JSONArray result = (JSONArray) jsonObject.get("result");

            HabitatDao habitatDao = DaoFactory.getHabitatDao();
            SpeciesDao speciesDao = DaoFactory.getSpeciesDao();


            for (int i = 0; i < result.size(); i++) {
                JSONObject o = (JSONObject) result.get(i);
                String label = (String)o.get("habitat");
                Habitat habitat = habitatDao.findByLabel(label);

                if (habitat == null) {
                    habitat = new Habitat();
                    habitat.setLabel(label);
                    habitatDao.create(habitat);
                }

                species.addHabitat(habitat);
                speciesDao.update(species);

                System.out.println(species.getName() + " lives in " + habitat.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadThreats(Species species) {
        String url = null;
        String formattedName = species.getScientificName().replace(" ", "%20");
        url = "http://apiv3.iucnredlist.org/api/v3/threats/species/name/" + formattedName + "?token=" + IUCN_Token;

        try {
            String jsonString = IOUtils.toString(new URL(url));

            JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(jsonString);
            JSONArray result = (JSONArray) jsonObject.get("result");

            ThreatDao threatDao = DaoFactory.getThreatDao();
            SpeciesDao speciesDao = DaoFactory.getSpeciesDao();


            for (int i = 0; i < result.size(); i++) {
                JSONObject o = (JSONObject) result.get(i);
                String title = (String)o.get("title");

                if (title != null) {
                    Threat threat = threatDao.findByTitle(title);

//                    if (threat == null) {
//                        threat = new Threat();
//                        threat.setTitle(title);
//                        threatDao.create(threat);
//                    }

                    species.addThreat(threat);
                    speciesDao.update(species);

                    System.out.println(species.getName() + " is threatened by " + threat.toString());
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMeasures(Species species) {
        String url = null;
        String formattedName = species.getScientificName().replace(" ", "%20");
        url = "http://apiv3.iucnredlist.org/api/v3/measures/species/name/" + formattedName + "?token=" + IUCN_Token;

        try {
            String jsonString = IOUtils.toString(new URL(url));

            JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(jsonString);
            JSONArray result = (JSONArray) jsonObject.get("result");

            MeasureDao measureDao = DaoFactory.getMeasureDao();
            SpeciesDao speciesDao = DaoFactory.getSpeciesDao();


            for (int i = 0; i < result.size(); i++) {
                JSONObject o = (JSONObject) result.get(i);
                String title = (String)o.get("title");

                if (title != null) {
                    Measure measure = measureDao.findByTitle(title);

                    if (measure == null) {
                        measure = new Measure();
                        measure.setTitle(title);
                        measureDao.create(measure);
                    }

                    species.addMeasure(measure);
                    speciesDao.update(species);

                    System.out.println(species.getName() + " is concerned by " + measure.toString());
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCountries(Species species) {
        String url = null;
        String formattedName = species.getScientificName().replace(" ", "%20");
        url = "http://apiv3.iucnredlist.org/api/v3/species/countries/name/" + formattedName + "?token=" + IUCN_Token;

        try {
            String jsonString = IOUtils.toString(new URL(url));

            JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(jsonString);
            JSONArray result = (JSONArray) jsonObject.get("result");

            CountryDao countryDao = DaoFactory.getCountryDao();
            SpeciesDao speciesDao = DaoFactory.getSpeciesDao();


            for (int i = 0; i < result.size(); i++) {
                JSONObject o = (JSONObject) result.get(i);
                String name = (String)o.get("country");
                String id = (String)o.get("code");

                if (id != null) {
                    Country country = countryDao.findById(id);

                    if (country == null) {
                        country = new Country(id, name);
                        countryDao.create(country);
                    }

                    species.addCountry(country);
                    speciesDao.update(species);

                    System.out.println(species.getName() + " is located in " + country.toString());
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadOtherSpecies(Family family) {

        String speciesQuery = "PREFIX dbo: <http://dbpedia.org/ontology/>\n" +
                "PREFIX dbp: <http://dbpedia.org/property/>\n" +
                "PREFIX dbr: <http://dbpedia.org/resource/>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "\n" +
                "SELECT DISTINCT ?name ?scientificName ?description ?thumbnail ?conservationStatus\n" +
                "WHERE \n" +
                "{\n" +
                "?species dbo:family dbr:" + family.getName() + " ;\n" +
                " rdfs:label ?name ;\n" +
                " dbp:trinomial ?scientificName ;\n" +
                " dbo:abstract ?description ;\n" +
                " dbo:thumbnail ?thumbnail ;\n" +
                " dbo:conservationStatus ?conservationStatus .\n" +
                "\n" +
                "FILTER (\n" +
                "  langMatches(lang(?description),\"en\") &&\n" +
                "  langMatches(lang(?name),\"en\")\n" +
                ")\n" +
                "}";
        Query query = QueryFactory.create(speciesQuery);
        QueryExecution qe = QueryExecutionFactory.sparqlService(sparqlEndpoint, query);

        try {

            ResultSet results = qe.execSelect();
            SpeciesDao speciesDao = DaoFactory.getSpeciesDao();
            ConservationStatusDao conservationStatusDao = DaoFactory.getConservationStatusDao();

            for (; results.hasNext(); ) {
                QuerySolution soln = results.nextSolution();

                String name = soln.getLiteral("name").getString();
                Species species = speciesDao.findByName(name);

                if (species == null) {
//                    Create species if not created yet
                    species = new Species();
                    species.setName(name);
                    species.setScientificName(soln.getLiteral("scientificName").getString());
                    species.setDescription(soln.getLiteral("description").toString());
                    species.setImage(soln.getResource("thumbnail").toString());
//                    Conservation Status
                    String status = soln.getLiteral("conservationStatus").toString();
                    ConservationStatus conservationStatus = conservationStatusDao.findById(status);
                    if (conservationStatus != null) {
                        species.setConservationStatus(conservationStatus);
                    }

                    species.setFamily(family);

                    speciesDao.create(species);
                    System.out.println(family.getName() + " : " + species.getName());
                }

                else {
                    System.out.println(family.getName() + " : " + species.getName() + " already exists");
                }

            }

        } finally {
//      Important - free up resources used running the query
            qe.close();

        }
    }

    public void load() {
        FamilyDao familyDao = DaoFactory.getFamilyDao();
        ArrayList<Family> families = (ArrayList<Family>) familyDao.findAll(Family.class);

        for (Family family : families) {
            loadSpecies(family);
        }
    }

    public void update() {
//        SpeciesDao speciesDao = DaoFactory.getSpeciesDao();
//        ArrayList<Species> species = (ArrayList<Species>) speciesDao.findAll(Species.class);

        FamilyDao familyDao = DaoFactory.getFamilyDao();
        Family family = familyDao.findById(29);
//        loadOtherSpecies(family);

        System.out.println(family.toString());
        Set<Species> species = family.getSpecies();

        for (Species s : species) {
            System.out.println(s.toString());

            if (s.getHabitats().isEmpty()) {
                loadHabitats(s);
            }

            if (s.getThreats().isEmpty()) {
                loadThreats(s);
            }

            if (s.getMeasures().isEmpty()) {
                loadMeasures(s);
            }
//
//            if (s.getCountries().isEmpty()) {
//                loadCountries(s);
//            }

        }

    }
}
