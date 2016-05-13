package servlet;

import dao.DaoFactory;
import dao.FamilyDao;
import entity.Family;
import entity.Species;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by emiliedao on 5/13/16.
 */
@WebServlet("/family")
public class FamilyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String familyName = request.getParameter("name");
        FamilyDao familyDao = DaoFactory.getFamilyDao();
        Family family = familyDao.findByName(familyName);

        if (family != null) {
            request.setAttribute("family", family);
            List<Species> species = family.getSpecies();
            request.setAttribute("species", species);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/family.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
