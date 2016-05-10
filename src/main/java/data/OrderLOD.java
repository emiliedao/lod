package data;

import dao.BiologyClassDao;
import dao.DaoFactory;
import dao.OrderDao;
import entity.BiologyClass;
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
public class OrderLOD extends LOD {
    private String rdfFile = "src/main/resources/rdf/Mammal.rdf";

    /**
     * Retrieve the list of orders of the mammal biology class, using a RDF file
     * @return
     */
    public ArrayList<Order> getOrders() {
        Model model = ModelFactory.createDefaultModel();
        InputStream in = null;

        String ordersQuery ="PREFIX wo: <http://purl.org/ontology/wo/>\n" +
                "\n" +
                "SELECT *\n" +
                "WHERE \n" +
                "{\n" +
                "?order a wo:Order .\n" +
                "}";
        Query query = QueryFactory.create(ordersQuery);

//      Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, model);

        ArrayList<Order> orders = new ArrayList<Order>();

        try {

//            Create model from RDF file
            in = new FileInputStream(new File(rdfFile));
            model.read(in, "");
            in.close();

            ResultSet results = qe.execSelect();

//            Output query results
//            ResultSetFormatter.out(System.out, results, query);

            for ( ; results.hasNext() ; )
            {
                QuerySolution soln = results.nextSolution() ;
                Resource r = soln.getResource("order") ;

                String orderName = r.toString().replaceFirst("file:///nature/life/", "");
                orderName = orderName.replaceFirst("#class", "");

//                Create order
                Order order = new Order();
                order.setName(orderName);
                orders.add(order);
            }

        } catch (IOException e) { e.printStackTrace(); }

        finally { qe.close(); }

        return orders;

    }


    public void loadOrders() {
        ArrayList<Order> orders = getOrders();
        BiologyClassDao biologyClassDao = DaoFactory.getBiologyClassDao();
        BiologyClass mammal = biologyClassDao.findById(1);

        OrderDao orderDao = DaoFactory.getOrderDao();

//        For each order, add description, image and biology class and store it into the database
        for (Order order : orders) {
            order.setDescription(getDbpediaDescription(order.getName()));
            String rdfFile = "src/main/resources/rdf/orders/" + order.getName() + ".rdf";
            order.setImage(getBBCImage(rdfFile));
            order.setBiologyClass(mammal);
            orderDao.create(order);
        }

    }

    public void load() {
        loadOrders();
    }

    public void update() {

    }


}
