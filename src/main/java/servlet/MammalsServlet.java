package servlet;

import dao.BiologyClassDao;
import dao.DaoFactory;
import dao.OrderDao;
import entity.BiologyClass;
import entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by emiliedao on 5/11/16.
 */
@WebServlet("/mammals")
public class MammalsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Mammals data
        BiologyClassDao biologyClassDao = DaoFactory.getBiologyClassDao();
        BiologyClass mammal = biologyClassDao.findById(1);
        mammal.setDescription(mammal.getDescription().replace("\n", "</p><p>"));
        request.setAttribute("mammal", mammal);

//        List of orders
        OrderDao orderDao = DaoFactory.getOrderDao();
        ArrayList<Order> orders = (ArrayList<Order>) orderDao.findAll(Order.class);

//        Truncate description
        for (Order order : orders) {
            order.setDescription(order.getDescription().substring(0, 77) + "...");
        }

        request.setAttribute("orders", orders);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/mammals.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
