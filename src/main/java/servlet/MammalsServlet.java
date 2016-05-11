package servlet;

import dao.BiologyClassDao;
import dao.DaoFactory;
import entity.BiologyClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by emiliedao on 5/11/16.
 */
@WebServlet("/mammals")
public class MammalsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BiologyClassDao biologyClassDao = DaoFactory.getBiologyClassDao();
        BiologyClass mammals = biologyClassDao.findById(1);
        request.setAttribute("mammalsImg", mammals.getImage());
        request.setAttribute("mammalsDescription", mammals.getDescription());

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/mammals.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
