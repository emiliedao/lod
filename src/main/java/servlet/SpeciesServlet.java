package servlet;

import dao.DaoFactory;
import dao.SpeciesDao;
import entity.Habitat;
import entity.Measure;
import entity.Species;
import entity.Threat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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

        Set<Habitat> habitats = new HashSet<Habitat>(species.getHabitats());
        request.setAttribute("habitats", habitats);

        Set<Threat> threats = new HashSet<Threat>(species.getThreats());
        request.setAttribute("threats", threats);

        Set<Measure> measures = new HashSet<Measure>(species.getMeasures());
        request.setAttribute("measures", measures);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/species.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
