package servlet;

import dao.DaoFactory;
import dao.FamilyDao;
import dao.SpeciesDao;
import entity.Family;
import entity.Species;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by emiliedao on 5/13/16.
 */
@WebServlet("/family")
public class FamilyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Find family
        String familyName = request.getParameter("name");
        FamilyDao familyDao = DaoFactory.getFamilyDao();
        Family family = familyDao.findByName(familyName);
        request.setAttribute("family", family);

        SpeciesDao speciesDao = DaoFactory.getSpeciesDao();

        List<Species> species;
        if (family != null) {
//            Get letter parameter for pagination
            String view = request.getParameter("view");


            if (view == null) {
                view = "A";
            }

//            Display all the species from the family
            if (view.equals("all")) {
                species = speciesDao.findByFamily(family);
            }

            else {
//                Find species beginning by letter
                species = speciesDao.findByLetterAndFamily(view.charAt(0), family);
            }

            request.setAttribute("species", species);
            request.setAttribute("view", view);

        }


//        Variable for alphabet display
        HashMap<Character, Integer> alphabet = new HashMap<Character, Integer>();
        Character l = 'A';
        for (int i = 0; i < 26; i++) {
            alphabet.put(l, speciesDao.countByLetterAndFamily(l, family));
            l++;
        }
        request.setAttribute("alphabet", alphabet);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/family.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
