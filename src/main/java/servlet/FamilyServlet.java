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
import java.util.List;

/**
 * Created by emiliedao on 5/13/16.
 */
@WebServlet("/family")
public class FamilyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Get letter parameter for pagination
        String letter = request.getParameter("letter");

        if (letter == null) {
            letter = "A";
        }

//        System.out.println("parameter is " + letter);
        request.setAttribute("letter", letter);

//        Find family
        String familyName = request.getParameter("name");
        FamilyDao familyDao = DaoFactory.getFamilyDao();
        Family family = familyDao.findByName(familyName);
        request.setAttribute("family", family);

//        Find species beginning by letter
        SpeciesDao speciesDao = DaoFactory.getSpeciesDao();

        if (family != null) {
            List<Species> species = speciesDao.findByLetterAndFamily(letter.charAt(0), family);
//            for (Species s : species) {
//                System.out.println(s.toString());
//            }
            request.setAttribute("species", species);
        }

//        Variable for alphabet display
        ArrayList<Character> alphabet = new ArrayList<Character>();
        Character l = 'A';
        for (int i = 0; i < 26; i++) {
            alphabet.add(l);
            l++;
        }
        request.setAttribute("alphabet", alphabet);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/family.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
