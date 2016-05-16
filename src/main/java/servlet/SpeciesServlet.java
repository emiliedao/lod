package servlet;

import dao.DaoFactory;
import dao.SpeciesDao;
import entity.Species;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by emiliedao on 5/13/16.
 */
@WebServlet("/species")
public class SpeciesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String speciesName = request.getParameter("name");
        SpeciesDao speciesDao = DaoFactory.getSpeciesDao();
        Species species = speciesDao.findByName(speciesName);
        request.setAttribute("species", species);


        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/species.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
