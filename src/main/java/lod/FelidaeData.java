package lod;

/**
 * Created by emiliedao on 4/14/16.
 */
public class FelidaeData extends FamilyData {

    public FelidaeData() {
//        queryString = "PREFIX dbo: <http://dbpedia.org/ontology/>" +
//                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
//                "SELECT ?felidae ?name " +
//                "WHERE {" +
//                "<http://dbpedia.org/resource/Felidae> ^dbo:family ?felidae ." +
//                "?felidae rdfs:label ?name ." +
//                "FILTER (langMatches(lang(?name),\"en\"))" +
//                "}";

        super("felidae");
    }

}
