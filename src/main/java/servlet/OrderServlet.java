package servlet;

import dao.DaoFactory;
import dao.OrderDao;
import entity.Family;
import entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by emiliedao on 5/12/16.
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String orderName = request.getParameter("name");
        OrderDao orderDao = DaoFactory.getOrderDao();
        Order order = orderDao.findByName(orderName);

        if (order != null) {
            request.setAttribute("order", order);
            List<Family> families = order.getFamilies();

            request.setAttribute("families", families);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/order.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
