package servlet;

import dao.CountryDao;
import dao.DaoFactory;
import dao.SpeciesDao;
import entity.*;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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

        Set<Habitat> habitats = species.getHabitats();
        request.setAttribute("habitats", habitats);

        Set<Threat> threats = species.getThreats();
        request.setAttribute("threats", threats);

        Set<Measure> measures = species.getMeasures();
        request.setAttribute("measures", measures);

//        Get countries occurrences
        String countriesOccurrences = getCountriesOccurrences(species);
        request.setAttribute("countriesOccurrences", countriesOccurrences);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/species.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String getCountriesOccurrences(Species species) {
        String countriesOccurrences = "[";
        String url = null;
        String formattedName = species.getScientificName().replace(" ", "%20");
        url = "http://apiv3.iucnredlist.org/api/v3/species/countries/name/" + formattedName + "?token=72a46a72cd71144d445d6ce0d8ccb67709db20ca995dbe9635155d7ec6284207";

        try {
            String jsonString = IOUtils.toString(new URL(url));

            JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(jsonString);
            JSONArray result = (JSONArray) jsonObject.get("result");


//            Get countries codes
            for (int i = 0; i < result.size(); i++) {
                JSONObject o = (JSONObject) result.get(i);
                String code = (String) o.get("code");

                countriesOccurrences += "{ code: '" + code + "', value: 1 }";

                if (code != null) {
                    if (i != result.size() - 1) {
                        countriesOccurrences += ", ";
                    }
                }

            }

            countriesOccurrences += "]";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countriesOccurrences;
    }
}
