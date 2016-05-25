package servlet;

import dao.ConservationStatusDao;
import dao.DaoFactory;
import dao.SpeciesDao;
import entity.ConservationStatus;
import entity.Species;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;

/**
 * Created by emiliedao on 5/25/16.
 */
@WebServlet("/statistics")
public class StatisticsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String speciesByStatus = getSpeciesByStatus();
        System.out.println(speciesByStatus);
        request.setAttribute("speciesByStatus", speciesByStatus);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/statistics.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Build the string for pie chart presenting the percentage of species by conservation status
     * @return the string containing the data
     */
    private String getSpeciesByStatus() {

        SpeciesDao speciesDao = DaoFactory.getSpeciesDao();
        ConservationStatusDao conservationStatusDao = DaoFactory.getConservationStatusDao();
        List<ConservationStatus> status = conservationStatusDao.findAll(ConservationStatus.class);

//        Build string data
        String speciesByStatus = "[";
        for (ConservationStatus s : status) {
            int count = speciesDao.countByConservationStatus(s);
            int total = speciesDao.countAll();
            float percentage = count * 100 / total;
            String label = s.getLabel();

            speciesByStatus += "{ name: '" + label + "', "
                    + "y: " + percentage + ", "
                    + "color: '" + chooseColor(label) + "' }";
            if (status.indexOf(s) != status.size() - 1) {
                speciesByStatus += ",";
            }
        }
        speciesByStatus += "]";
        return  speciesByStatus;
    }

    private String chooseColor(String status) {
        String color = "";
        if (status.equals("Critically endangered")) {
            color = "rgb(255,116,116)";
        }

        else if (status.equals("Endangered")) {
            color = "rgb(255,117,153)";
        }

        else if (status.equals("Vulnerable")) {
            color = "#f7a35c";
        }

        else if (status.equals("Near threatened")) {
            color = "#e4d354";
        }

        else if (status.equals("Least concern")) {
            color = "#90ed7d";
        }

        else if (status.equals("Extinct in the wild")) {
            color = "#7cb5ec";
        }

        else if (status.equals("Extinct")) {
            color = "#8085e9";
        }

        else if (status.equals("Data deficient")) {
            color = "#434348";
        }

        else {
            color = "#e7e7e7";
        }

        return color;

    }

    public String getSpeciesByCountry(ConservationStatus status) {
        String speciesByCountry = "[";
        HashMap<String, Integer> countByCountry = new HashMap<String, Integer>();

        SpeciesDao speciesDao = DaoFactory.getSpeciesDao();
        List<Species> species = speciesDao.findByConservationStatus(status);

        for (Species s : species) {

        }

        speciesByCountry += "]";

        return null;
    }
}
