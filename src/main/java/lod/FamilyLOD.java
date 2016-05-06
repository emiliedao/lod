package lod;

import dao.DaoFactory;
import dao.FamilyDao;
import dao.OrderDao;
import entity.Family;
import entity.Order;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by emiliedao on 5/6/16.
 */
public class FamilyLOD extends LOD {

    public ArrayList<Family> getFamilies(String order) {
        Model model = ModelFactory.createDefaultModel();
        InputStream in = null;

        String ordersQuery = "PREFIX wo: <http://purl.org/ontology/wo/>\n" +
                "\n" +
                "SELECT *\n" +
                "WHERE \n" +
                "{\n" +
                "?family a wo:Family .\n" +
                "}";
        Query query = QueryFactory.create(ordersQuery);

//      Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, model);

        ArrayList<Family> families = new ArrayList<Family>();

        try {

//            Create model from RDF file
            in = new FileInputStream(new File("src/main/resources/rdf/orders/" + order + ".rdf"));
            model.read(in, "");
            in.close();

            ResultSet results = qe.execSelect();

//            Output query results
//            ResultSetFormatter.out(System.out, results, query);

            for ( ; results.hasNext() ; )
            {
                QuerySolution soln = results.nextSolution() ;
                Resource r = soln.getResource("family") ;

                String familyName = r.toString().replaceFirst("file:///nature/life/", "");
                familyName = familyName.replaceFirst("#order", "");

//                Family creation
                Family family = new Family();
                family.setName(familyName);
                families.add(family);
            }

        } catch (IOException e) { e.printStackTrace(); }

        finally { qe.close(); }

        return families;
    }

    public void loadFamilies() {
        OrderDao orderDao = DaoFactory.getOrderDao();
        ArrayList<Order> orders = (ArrayList<Order>)orderDao.findAll(Order.class);

        FamilyDao familyDao = DaoFactory.getFamilyDao();

        for (Order order : orders) {
            ArrayList<Family> families = getFamilies(order.getName());

            for (Family family : families) {
                family.setDescription(getDbpediaDescription(family.getName()));
                family.setOrder(order);
                familyDao.create(family);
            }
        }
    }

    public void load() {
        loadFamilies();
    }

    public void update() {

    }
}
