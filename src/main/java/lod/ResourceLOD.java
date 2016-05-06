package lod;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by emiliedao on 5/5/16.
 */
public abstract class ResourceLOD {

    protected String sparqlEndpoint = "http://dbpedia.org/sparql";

    /**
     * Get DBpedia description of a resource
     * @param resourceName the name of the resource
     * @return the description
     */
    String getDbpediaDescription(String resourceName) {

        String descriptionQuery = "PREFIX dbo: <http://dbpedia.org/ontology/> " +
            "PREFIX dbr: <http://dbpedia.org/resource/> " +
            "SELECT ?description " +
             "WHERE { " +
                "dbr:" + resourceName + " dbo:abstract ?description . " +
                "FILTER (langMatches(lang(?description),\"en\"))" +
            "}";

        Query query = QueryFactory.create(descriptionQuery);

//      Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.sparqlService(sparqlEndpoint, query);
        String description = "";

        try {

            ResultSet results = qe.execSelect();
//            ResultSetFormatter.out(System.out, results, query);

            for ( ; results.hasNext() ; )
            {
                QuerySolution soln = results.nextSolution() ;
                Literal l = soln.getLiteral("description") ;
                description = l.getString();
            }

        } finally {
//      Important - free up resources used running the query
            qe.close();

        }

        return description;
    }


    /**
     * Get the picture URL from a BBC RDF file
     * @param file the RDF fie
     * @return the URL of the picture
     */
    public String getBBCpicture(String file) {

        Model model = ModelFactory.createDefaultModel();
        InputStream in = null;

        String ordersQuery = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" +
                "\n" +
                "SELECT ?image\n" +
                "WHERE \n" +
                "{\n" +
                "?image foaf:depicts ?resource\n" +
                "}\n";
        Query query = QueryFactory.create(ordersQuery);

//      Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, model);

        String imageURL = "";

        try {

//            Create model from RDF file
            in = new FileInputStream(new File(file));
            model.read(in, "");
            in.close();

            ResultSet results = qe.execSelect();

            for ( ; results.hasNext() ; )
            {
                QuerySolution soln = results.nextSolution() ;
                Resource r = soln.getResource("image") ;
                imageURL = r.toString();
            }

        } catch (IOException e) { e.printStackTrace(); }

        finally { qe.close(); }

        return imageURL;
    }

    public abstract void load();
    public abstract void update();

}
