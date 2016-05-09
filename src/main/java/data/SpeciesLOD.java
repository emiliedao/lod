package data;

import dao.ConservationStatusDao;
import dao.DaoFactory;
import dao.FamilyDao;
import dao.SpeciesDao;
import entity.ConservationStatus;
import entity.Family;
import entity.Species;
import org.apache.jena.query.*;

import java.util.ArrayList;

/**
 * Created by emiliedao on 5/9/16.
 */
public class SpeciesLOD extends LOD {

    /**
     * Retrieve from DPpedia all the species belonging to a family and store them into the database
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

            for ( ; results.hasNext() ; )
            {
                QuerySolution soln = results.nextSolution() ;

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

    public void load() {
        FamilyDao familyDao = DaoFactory.getFamilyDao();
        ArrayList<Family> families = (ArrayList<Family>) familyDao.findAll(Family.class);

        for (Family family : families) {
            loadSpecies(family);
        }
    }

    public void update() {

    }
}
