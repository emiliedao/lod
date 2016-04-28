package dataTest;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;
import java.util.HashMap;


/**
 * Created by emiliedao on 4/15/16.
 */
public abstract class FamilyData extends LinkedData {

    protected String familyName;
//    protected String description;
    protected String sparqlEndpoint = "http://dbpedia.org/sparql";

    protected String speciesQuery;
    protected HashMap<String, String> species = new HashMap(); // <name, URI>

    public FamilyData(String familyName) {
        this.familyName = familyName;

        speciesQuery = "PREFIX dbo: <http://dbpedia.org/ontology/>" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "SELECT ?felidae ?name " +
                "WHERE {" +
                "<http://dbpedia.org/resource/Felidae> ^dbo:family ?" + familyName + " ." +
                "?felidae rdfs:label ?name ." +
                "FILTER (langMatches(lang(?name),\"en\"))" +
                "} " +
                "ORDER BY ?name";
    }


    public HashMap<String, String> getSpecies() {
        loadSpecies();
        return species;
    }

    protected void loadSpecies() {
        Query query = QueryFactory.create(speciesQuery);

//      Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.sparqlService(sparqlEndpoint, query);

        try {

            ResultSet results = qe.execSelect();
//            ResultSetFormatter.out(System.out, results, query);

            for ( ; results.hasNext() ; )
            {
                QuerySolution soln = results.nextSolution() ;
                Resource r = soln.getResource(familyName) ; // Get a result variable - must be a resource
                Literal l = soln.getLiteral("name") ;   // Get a result variable - must be a literal
                species.put(l.getString(), r.getURI());
            }

        } finally {
//      Important - free up resources used running the query
            qe.close();

        }

    }

}
